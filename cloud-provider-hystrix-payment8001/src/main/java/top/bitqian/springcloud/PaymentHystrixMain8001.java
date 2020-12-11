package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * boot payment hystrix demo
 * @author echo lovely
 * @date 2020/12/10 20:17
 */

@EnableCircuitBreaker // 开启服务降级
@EnableEurekaClient // discovery by eureka
@SpringBootApplication
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentHystrixMain8001.class, args);

    }

}
