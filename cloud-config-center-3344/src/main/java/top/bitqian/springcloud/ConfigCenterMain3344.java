package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author echo lovely
 * @date 2020/12/13 16:15
 */

@EnableConfigServer // 配置中心服务端
@SpringBootApplication
public class ConfigCenterMain3344 {

    public static void main(String[] args) {
        // 测试服务端 http://localhost:3344/config-dev.yml/master
        // 1. /{application}-{profile}[/{label}] 返回json
        // 2. /{application}-{profile}.yml 默认master
        // 3. /[{label}]/{application}-{profile} 推荐

        SpringApplication.run(ConfigCenterMain3344.class, args);
    }

}
