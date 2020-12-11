package top.bitqian.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * hystrix in client~
 * @author echo lovely
 * @date 2020/12/10 22:30
 */

@DefaultProperties(defaultFallback = "global_fallback_method") // 全局的兜底方法
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;


    // 开启jmeter轰炸8001端口的timout服务时
    // 80访问ok接口，可能会出现超时情况，原因是. 8001服务繁忙，访问太多
    // feign.RetryableException: Read timed out executing
    // GET http://CLOUD-PROVIDER-HYSTRIX-PAYMENT/payment/hystrix/ok/1

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {

        return service.payment_ok(id);
    }

    // 一般服务降级针对客户端
    /*@HystrixCommand(fallbackMethod = "payment_timeout_fallback_method", commandProperties = {
            // 设置当前方法必须1.5s响应 而服务端的方法要3s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") // 只要是测试超时，目测5000ms写不写无所谓，都会进兜底方法
    })*/
    @HystrixCommand // 使用全局的解决方法
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id) {
        System.out.println(1/0);
        log.info("success~ =============> ");
        String res = service.payment_timeout(id);
        return res;
    }

    // 兜底方法
    public String payment_timeout_fallback_method(@PathVariable("id") Integer id) {
        log.info("consumer sth bad........");

        return "我是消费者80，系统繁忙或者报错，请稍后再试~";
    }

    // 全局的兜底方法, 通用的, 一对一的方法代码冗余~
    public String global_fallback_method() {

        return "当前服务不可用, 系统繁忙或者报错, 请稍后再试";
    }

}
