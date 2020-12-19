package top.bitqian.springcloud.alibaba.service.impl;

import org.springframework.stereotype.Component;
import top.bitqian.springcloud.alibaba.service.PaymentService;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;

/**
 * openFeign降级类
 * @author echo lovely
 * @date 2020/12/19 15:57
 */

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(444444,
                "sth maybe error, this serial is not exist...",
                new Payment(id, null));
    }
}
