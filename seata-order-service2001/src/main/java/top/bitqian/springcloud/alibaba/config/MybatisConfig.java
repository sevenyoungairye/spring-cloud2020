package top.bitqian.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis configuration
 * @author echo lovely
 * @date 2020/12/20 16:02
 */

@Configuration
@MapperScan({"top.bitqian.springcloud.alibaba.dao"})
public class MybatisConfig {

}

