package top.bitqian.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author echo lovely
 * @date 2020/12/20 15:59
 */

@EnableDiscoveryClient // 服务发现
@EnableFeignClients // 启用feign
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SeataOrderMainApp2001 {

    public static void main(String[] args) {

        SpringApplication.run(SeataOrderMainApp2001.class, args);

    }

}
