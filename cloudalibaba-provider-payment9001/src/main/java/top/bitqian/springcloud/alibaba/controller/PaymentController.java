package top.bitqian.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * adorable 123
 * @author echo lovely
 * @date 2020/12/16 11:06
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public String getPayment(@PathVariable("id") Integer id) {

        return  "(*^_^*), welcome to na_cos client~ \t" + "port: " + serverPort + "\tid: " + id;
    }

}
