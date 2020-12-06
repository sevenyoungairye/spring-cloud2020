package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo lovely
 * @date 2020/12/6 10:17
 */

// 开启服务发现
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class, args);
    }

}
