package top.bitqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo lovely
 * @date 2020/12/18 20:41
 */

@EnableDiscoveryClient // register in nacos
@SpringBootApplication
public class PaymentMain9003 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain9003.class, args);

    }

}
