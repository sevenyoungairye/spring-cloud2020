package top.bitqian.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关规则bean配置
 * @author echo lovely
 * @date 2020/12/12 16:53
 */

@Configuration
public class GatewayConfig {

    // 可以配置多个bean, 根据规则跳转到不同的url
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeBuilder) {

        RouteLocatorBuilder.Builder routes = routeBuilder.routes();

        routes.route("adorable1",
                r -> r.path("/team"). // localhost:9527/team
                        uri("https://github.com/team")). // to team
                        build();

        return routes.build();
    }

    @Bean
    public RouteLocator customerRouteLocator1(RouteLocatorBuilder routeBuilder) {

        RouteLocatorBuilder.Builder routes = routeBuilder.routes();

        routes.route("adorable2",
                r -> r.path("/explore"). // localhost:9527/explore
                        uri("https://github.com/explore")). // to  explore
                        build();

        return routes.build();
    }

}
