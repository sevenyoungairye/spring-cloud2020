package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author echo lovely
 * @date 2020/12/3 21:43
 */

// 表示 用于向使用consul或者zookeeper作为注册中心时注册服务~
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8004 {

    // 测试，断掉客户端时, zookeeper不会立即干掉服务。会等客户端连接上, 过一会连接不上 会干掉服务。
    // 是临时结点。
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }

}
