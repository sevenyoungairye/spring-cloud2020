package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 通过zk远程调用8004
 * @author echo lovely
 * @date 2020/12/6 10:18
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public String payment() {

        // 调用cloud-provider-payment服务的controller 地址
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

        log.info("res---------->" + result);

        return result;
    }

}
