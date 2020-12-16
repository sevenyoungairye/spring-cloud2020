package top.bitqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo lovely
 * @date 2020/12/16 15:37
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377 {

    public static void main(String[] args) {

        // boot
        SpringApplication.run(NacosConfigClientMain3377.class, args);

    }

}
