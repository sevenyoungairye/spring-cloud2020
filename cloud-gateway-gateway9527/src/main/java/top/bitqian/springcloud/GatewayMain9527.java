package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * a lovely boot.. mainBoot
 * @author echo lovely
 * @date 2020/12/12 16:22
 */

@EnableEurekaClient // 开启入驻eureka
@SpringBootApplication
public class GatewayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }

}
