package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;
import top.bitqian.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * 支付接口
 * @author echo lovely
 * @date 2020/11/30 16:43
 */

@RestController
@Slf4j // lombok 日志打印记录
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult createPayment(Payment payment) {
        int res = paymentService.createPayment(payment);
        log.info("==========================>完成新增");
        if (res > 0) {
            log.info("================================> 新增成功");
            return new CommonResult<>(200, "create success", res);
        } else {

            return new CommonResult<>(400, "create failure ~", res);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            log.info("查询成功=====>" + payment);
            return new CommonResult<>(200, "find it!", payment);
        }

        log.info("nothing..");

        return new CommonResult<>(444, "nothing..");

    }

}
