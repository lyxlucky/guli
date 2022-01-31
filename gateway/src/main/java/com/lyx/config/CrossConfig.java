package com.lyx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author liao 2021/10/26
 */
@Configuration
public class CrossConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){
        // 跨域配置源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        // 跨域配置
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 1 配置跨域
        // 允许所有头进行跨域
        corsConfiguration.addAllowedHeader("*");
        // 允许所有请求方式进行跨域
        corsConfiguration.addAllowedMethod("*");
        // 允许所有请求来源进行跨域
        corsConfiguration.addAllowedOrigin("*");
        // 允许携带cookie进行跨域
        corsConfiguration.setAllowCredentials(true);
        // 2 任意路径都允许第1步配置的跨域
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }

}
