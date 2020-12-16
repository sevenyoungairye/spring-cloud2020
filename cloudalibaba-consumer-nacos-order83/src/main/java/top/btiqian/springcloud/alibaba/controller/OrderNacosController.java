package top.btiqian.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2020/12/16 12:01
 */

@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    // get from yaml~
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/consumer/payment/get/{id}")
    public String getPayment(@PathVariable("id") Integer id) {

        String res = restTemplate.getForObject(serviceUrl + "/payment/get/" + id, String.class);

        System.out.println("order83==================>" + res);

        return res;
    }

}
