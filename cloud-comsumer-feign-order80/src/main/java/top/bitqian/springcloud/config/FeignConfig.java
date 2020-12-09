package top.bitqian.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 记录调用服务端的日志
 * 通过调整日志级别，从而了解Feign中的http请求细节
 * 对feign接口调用情况，进行监控和输出~
 * None     默认的不显示任何日志
 * BASIC    仅记录请求方法，url，响应状态码，及执行时间
 * HEADERS  basic 请求响应的头信息
 * FULL     headers 请求响应的正文，数据
 * @author echo lovely
 * @date 2020/12/9 22:26
 */

@Configuration
public class FeignConfig {

    // 响应，请求信息~
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
