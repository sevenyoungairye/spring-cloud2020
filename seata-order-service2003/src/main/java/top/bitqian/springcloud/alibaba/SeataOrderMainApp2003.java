package top.bitqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo lovely
 * @date 2020/12/20 19:52
 */

@EnableDiscoveryClient
@SpringBootApplication
public class SeataOrderMainApp2003 {

    public static void main(String[] args) {

        SpringApplication.run(SeataOrderMainApp2003.class, args);

    }

}
