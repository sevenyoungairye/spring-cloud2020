package top.bitqian.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * feign 接口~
 * @author echo lovely
 * @date 2020/12/10 22:28
 */

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {


    @GetMapping("/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    String payment_timeout(@PathVariable("id") Integer id);


}
