package top.btiqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * na_cos main boot 83 port
 * @author echo lovely
 * @date 2020/12/16 11:59
 */

@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain83 {

    public static void main(String[] args) {

        SpringApplication.run(OrderNacosMain83.class, args);

    }

}
