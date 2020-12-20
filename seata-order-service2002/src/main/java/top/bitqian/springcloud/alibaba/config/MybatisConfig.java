package top.bitqian.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author echo lovely
 * @date 2020/12/20 17:25
 */

@Configuration
@MapperScan({"top.bitqian.springcloud.alibaba.dao"})
public class MybatisConfig {

}
