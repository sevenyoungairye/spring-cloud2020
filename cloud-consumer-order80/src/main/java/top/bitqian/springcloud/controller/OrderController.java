package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;

import javax.annotation.Resource;


/**
 * 80 消费者接口
 * 如果停掉8001端口，java.net.ConnectException: Connection refused: connect
 * @author echo lovely
 * @date 2020/11/30 19:38
 */

@RestController
@Slf4j
public class OrderController {

    // 单机版 一个支付服务提供者服务地址写死了
    // private static final String PAYMENT_URL = "http://localhost:8001";

    // 根据服务名通过一定的负载均衡算法找到具体的服务端口, 多个支付服务提供者
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    // 坑，多个服务提供者，不知道你具体的服务端口是哪个..
    // I/O error on GET request for "http://CLOUD-PAYMENT-SERVICE/payment/get/1":CLOUD-PAYMENT-SERVICE;
    // nested exception is java.net.UnknownHostException: CLOUD-PAYMENT-SERVICE

    @Resource
    private RestTemplate restTemplate;

    // 调用
    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {

        log.info("嘤嘤怪，跑通了吖。");
        // 调用8001服务接口..
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    // 调用查询~
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        log.info("嘤嘤怪，跑通了吖。消费者80调用8001..");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    // restTemplate~
    // https://docs.spring.io/spring-framework/docs/
    // 5.2.2.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html

    // getForEntity 返回状态码，响应头，响应体等..
    @GetMapping("/consumer/payment/getByEntity/{id}")
    public CommonResult getPaymentByEntity(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> entity =
                restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("调用成功~" + entity.getHeaders());

            return entity.getBody();
        }

        return new CommonResult<>(444, "系统故障...调用失败~");
    }

    // postForObject/postForEntity
    // postForEntity 新增
    @GetMapping("/consumer/payment/createByPostEntity")
    public CommonResult<Payment> createByPostEntity(Payment payment) {

        // 返回responseBody对象
        ResponseEntity<CommonResult> res = restTemplate.
                postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

        log.info("res------>" + res.getBody().toString());

        if (res.getStatusCode().is2xxSuccessful()) {

            return res.getBody();
        }

        return new CommonResult(444, "error");
    }

}
