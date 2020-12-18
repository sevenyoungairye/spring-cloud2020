package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo lovely
 * @date 2020/12/18 20:42
 */

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9004 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain9004.class, args);

    }

}
