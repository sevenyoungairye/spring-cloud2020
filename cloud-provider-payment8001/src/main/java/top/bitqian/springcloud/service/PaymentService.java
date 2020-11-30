package top.bitqian.springcloud.service;

import top.bitqian.springcloud.entity.Payment;

/**
 * @author echo lovely
 * @date 2020/11/30 16:41
 */

public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);

}
