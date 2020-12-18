package top.bitqian.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
    // @SentinelResource(value = "consumer/fallback", fallback = "fallbackHandler") // fallback 出现业务错误了该怎么办
    @SentinelResource(value = "consumer/fallback", blockHandler = "blockExceptionHandler") // block 不符合sentinel控制台规则
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

    // 出现异常 该处理的方法
    public CommonResult<Object> fallbackHandler(@PathVariable("id") Long id, Throwable te) {


        return new CommonResult<>(
                444,
                "sth error, handler fallback --->" + te.getMessage(),
                new Payment(id, null)
        );
    }


    // 出现不符合sentinel控制台的规则
    public CommonResult<Object> blockExceptionHandler(@PathVariable("id") Long id, BlockException e) {

        return new CommonResult<>(
                   444,
                "sentinel flow limit..." +
                         e.getMessage(), new Payment(id, null));
    }


}
