package top.bitqian.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * boot payment hystrix demo
 * @author echo lovely
 * @date 2020/12/10 20:17
 */

@EnableCircuitBreaker // 开启服务降级
@EnableEurekaClient // discovery by eureka
@SpringBootApplication
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentHystrixMain8001.class, args);

    }

    // 在被监控的服务中指定监控路径
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
