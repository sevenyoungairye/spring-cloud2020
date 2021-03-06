package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;
import top.bitqian.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2020/12/8 22:08
 */

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    // feign 的默认超时时间为1s
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // java.net.SocketTimeoutException: Read timed out 如果不设置超时控制就会报错
        return paymentFeignService.paymentFeignTimeout();
    }

}
