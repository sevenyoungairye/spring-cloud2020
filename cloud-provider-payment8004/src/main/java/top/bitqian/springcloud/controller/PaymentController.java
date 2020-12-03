package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author echo lovely
 * @date 2020/12/3 21:48
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/zk")
    public String getPaymentZooKeeper()
    {
        log.info("get server info ~");
        return "client port--> " + port + " \t" + UUID.randomUUID();
    }

}
