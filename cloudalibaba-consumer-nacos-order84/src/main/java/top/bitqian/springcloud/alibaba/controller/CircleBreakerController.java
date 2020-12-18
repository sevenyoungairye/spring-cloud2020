package top.bitqian.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;

import javax.annotation.Resource;

/**
 * 测试熔断
 * @author echo lovely
 * @date 2020/12/18 21:37
 */

@Slf4j
@RestController
public class CircleBreakerController
{

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id)
    {

        CommonResult res =
                restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常... IllegalArgumentException");
        }

        if (res.getData() == null) {
            throw new NullPointerException("空指针异常... NullPointerException");
        }

        return new CommonResult(200, "okk", res);
    }

}
