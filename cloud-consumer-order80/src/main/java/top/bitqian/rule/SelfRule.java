package top.bitqian.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon 负载均衡规则代替默认轮询规则
 * @author echo lovely
 * @date 2020/12/6 17:34
 */

@Configuration
public class SelfRule {

    @Bean
    public IRule getIRule() {

        // 随机
        return new RandomRule();
    }

}
