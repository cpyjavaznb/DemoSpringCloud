package org.example.Filter;

import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * GateWay全局过滤器，还有一种过滤器是通过配置文件进行配置，详情查看bootstrap.yml配置文件
 */
@Component
public class GateWayFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //模拟登录验证
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //判断请求对象中是否有authorization，且参数满足admin，模拟登录认证
        String authorization = queryParams.getFirst("authorization");
        if(!StringUtils.isEmpty(authorization)){
            if("admin".equals(authorization)){
                //验证成功直接放行
                return chain.filter(exchange);
            }
        }
        //设置拦截返回值 401未登录
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //拦截
        return exchange.getResponse().setComplete();
    }
}
