package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2020/12/10 20:26
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {

        String res = paymentService.payment_ok(id);

        log.info("============>" + res);

        return res;
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id) {

        String res = paymentService.payment_timeout(id);

        log.info("============>" + res);

        return res;
    }


}
