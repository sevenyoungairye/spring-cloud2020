package top.bitqian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * dashboard monitor service
 * @author echo lovely
 * @date 2020/12/12 11:57
 */

@EnableHystrixDashboard // 启动hystrix仪表盘监控
@SpringBootApplication
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }

}
