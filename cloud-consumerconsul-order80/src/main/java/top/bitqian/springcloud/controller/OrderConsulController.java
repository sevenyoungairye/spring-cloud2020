package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author echo lovely
 * @date 2020/12/6 12:01
 */

@RestController
@Slf4j
public class OrderConsulController {

    @Value("${server.port}")
    private Integer port;

    // 被调用的服务地址
    private static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String payment() {

        String res = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);

        return res + " \nport:" + port;
    }

}
