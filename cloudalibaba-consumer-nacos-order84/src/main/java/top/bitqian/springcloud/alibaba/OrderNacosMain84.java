package top.bitqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * a consumer client 84 port.
 * @author echo lovely
 * @date 2020/12/18 21:00
 */

// openfeign
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain84 {

    public static void main(String[] args) {

        SpringApplication.run(OrderNacosMain84.class, args);

    }

}
