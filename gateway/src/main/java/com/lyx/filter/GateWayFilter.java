package com.lyx.filter;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.lyx.utils.JwtUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author liao 2021/10/26
 */
//@Component
public class GateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst("token");
        if("options".equals(request.getMethod())){
            return chain.filter(exchange);
        }
        if (("/eduacl/user").equals(request.getURI().getPath())) {
            //登录接口，通过
            return chain.filter(exchange);
        }
        if (("/eduservice/user").equals(request.getURI().getPath())) {
            return chain.filter(exchange);
        }
        if (!("/eduacl/user").equals(request.getURI().getPath())) {
            // 如果请求头不存在 Token
            if (token == null) {
                return this.getResponseError(exchange);
            }
            try {
                JwtUtils.validateToken(token);
            } catch (Exception e) {
                e.printStackTrace();
                return this.getResponseError(exchange);
            }
            return chain.filter(exchange);
        }
        return this.getResponseError(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }

    private Mono<Void> getResponseError(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        JsonObject message = new JsonObject();
        message.addProperty("success", false);
        message.addProperty("code", 28004);
        message.addProperty("data", "鉴权失败");
        byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}