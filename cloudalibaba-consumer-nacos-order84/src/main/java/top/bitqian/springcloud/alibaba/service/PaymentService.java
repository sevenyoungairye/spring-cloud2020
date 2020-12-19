package top.bitqian.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.bitqian.springcloud.alibaba.service.impl.PaymentServiceImpl;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;

/**
 * openFeign 远程调用
 * @author echo lovely
 * @date 2020/12/19 15:52
 */

@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceImpl.class)
public interface PaymentService
{

    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


}
