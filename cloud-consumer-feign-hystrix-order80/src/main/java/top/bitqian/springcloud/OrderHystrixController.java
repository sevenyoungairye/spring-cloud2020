package top.bitqian.springcloud;

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


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id) {

        return service.payment_timeout(id);
    }

}
