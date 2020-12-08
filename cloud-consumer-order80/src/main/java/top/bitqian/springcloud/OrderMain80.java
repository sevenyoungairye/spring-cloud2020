package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// import org.springframework.cloud.netflix.ribbon.RibbonClient;
// import top.bitqian.rule.SelfRule;

/**
 * @author echo lovely
 * @date 2020/11/30 19:28
 */

// 指定 可定制化的负载均衡算法。
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = SelfRule.class) // 测试轮询算法，注释
@EnableEurekaClient // eureka客户端 服务消费者80
@SpringBootApplication
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
