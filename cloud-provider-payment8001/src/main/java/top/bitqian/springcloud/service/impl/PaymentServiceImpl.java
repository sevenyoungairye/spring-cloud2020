package top.bitqian.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.bitqian.springcloud.entity.Payment;
import top.bitqian.springcloud.mapper.PaymentMapper;
import top.bitqian.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * 支付相关业务..
 * @author echo lovely
 * @date 2020/11/30 16:42
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int createPayment(Payment payment) {
        return paymentMapper.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
