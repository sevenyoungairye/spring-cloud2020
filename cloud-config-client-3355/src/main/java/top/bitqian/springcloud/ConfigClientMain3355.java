package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 客户端配置 读取配置文件 从公共的服务端配置中心拿取
 * @author echo lovely
 * @date 2020/12/13 17:41
 */

@SpringBootApplication
public class ConfigClientMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }

}
