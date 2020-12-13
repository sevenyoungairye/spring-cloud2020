package top.bitqian.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 网关自定义过滤器配置
 * 官方有两种过滤器, 单一的和全局的。
 * @author echo lovely
 * @date 2020/12/13 14:37
 */

@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered { // global filter...

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("=======================gateway进来了======" + new Date());

        // 获取到请求中的参数
        String username = exchange.getRequest().getQueryParams().getFirst("username");

        if (username == null) {
            log.info("/(ㄒoㄒ)/~~ 用户名为空了，非法的用户名称......");

            // 406 不被服务器接受的
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            // 返回mono
            return exchange.getResponse().setComplete();
        }

        // 放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 数字越小, 越优先
        return 0;
    }
}
