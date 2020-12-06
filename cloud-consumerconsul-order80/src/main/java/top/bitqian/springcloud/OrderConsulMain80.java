package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo lovely
 * @date 2020/12/6 11:59
 */

@EnableDiscoveryClient
@SpringBootApplication
public class OrderConsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }

}
