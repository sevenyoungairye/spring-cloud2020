package top.bitqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * na_cos alibaba main boot~
 * -DServer.port=9011 --> copy a service
 * @author echo lovely
 * @date 2020/12/16 11:05
 */

@EnableDiscoveryClient // as a client
@SpringBootApplication
public class PaymentMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class, args);
    }

}
