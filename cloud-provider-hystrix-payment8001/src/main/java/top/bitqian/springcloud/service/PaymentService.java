package top.bitqian.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author echo lovely
 * @date 2020/12/10 20:21
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

        System.out.println(1/0);

        Integer timeout =  5; // 5s

        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName() +
                "timeout 呜呜呜~" + "id: " + id + "超时(s) " + timeout;
    }

    /**
     * 用于服务降级的兜底方法~
     * @param id a test id
     * @return a msg when append wrong thing to protect the service~
     */
    public String payment_timeout_handler(Integer id) {


        return "线程池: " + Thread.currentThread().getName() + " 系统繁忙或者报错~ id " + id + " /(ㄒoㄒ)/~~";
    }

}
