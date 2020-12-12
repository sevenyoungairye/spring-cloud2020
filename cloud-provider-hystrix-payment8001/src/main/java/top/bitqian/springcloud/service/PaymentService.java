package top.bitqian.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author echo lovely
 * @date 2020/12/10 20:21
 * <p>
 *     https://github.com/Netflix/Hystrix/wiki/How-To-Use
 * </p>
 */

@Service
public class PaymentService {

    public String payment_ok(Integer id) {

        return "线程池: " + Thread.currentThread().getName() + "ok O(∩_∩)O哈哈~ "
                + "id: " + id;
    }

    // 指定兜底的方法。和超时控制的时间范围。
    @HystrixCommand(fallbackMethod = "payment_timeout_handler", commandProperties = {
            // 设置当前方法必须3s响应
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String payment_timeout(Integer id) {

        // System.out.println(1/0);

        Integer timeout =  2; // 5s

        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName() +
                " timeout 呜~ 成功了 " + "id: " + id + "超时(s) " + timeout;
    }

    /**
     * 用于服务降级的兜底方法~
     * @param id a test id
     * @return a msg when append wrong thing to protect the service~
     */
    public String payment_timeout_handler(Integer id) {


        return "线程池: " + Thread.currentThread().getName() + " 系统繁忙或者报错~ id " + id + " /(ㄒoㄒ)/~~";
    }


    // 服务熔断
    // 大神论文 https://martinfowler.com/bliki/CircuitBreaker.html
    // 参数来自HystrixCommandProperties 配置来自官网
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸, 即不让访问, 但失败率小于60时, 会恢复访问
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        // hu_tool 生成唯一id, 去掉下划线
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }

}
