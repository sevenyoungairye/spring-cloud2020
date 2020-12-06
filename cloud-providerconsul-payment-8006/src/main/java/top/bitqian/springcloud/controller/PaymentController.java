package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 测试consul, 服务提供
 * @author echo lovely
 * @date 2020/12/6 11:36
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/payment/consul")
    public String payment() {

        log.info("consul provider 8006");

        return "consul with springcloud ------> " + port + UUID.randomUUID().toString();
    }

}
