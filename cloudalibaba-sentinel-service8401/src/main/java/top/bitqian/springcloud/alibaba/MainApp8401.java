package top.bitqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 将8401作为demo 被sentinel监控
 * @author echo lovely
 * @date 2020/12/17 11:10
 */

@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401 {

    public static void main(String[] args) {

        SpringApplication.run(MainApp8401.class, args);

    }

}
