package org.example.backend.common.security.config;

import jakarta.annotation.Resource;
import org.example.backend.common.security.filter.PerAuthRequestFilter;
import org.example.backend.common.security.filter.RestfulAccessDeniedHandler;
import org.example.backend.common.security.filter.RestfulAuthenticationEntryPoint;
import org.example.backend.common.security.service.AuthUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 10:41
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Resource
    private SecurityProperties securityProperties;
    @Resource
    private AuthUserDetailsService authUserDetailsService;
    @Resource
    private PerAuthRequestFilter perAuthRequestFilter;
    @Resource
    private RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;
    @Resource
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(registry -> registry
                        .requestMatchers(securityProperties.getIgnoreUrls())
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                //关闭csrf
                .csrf(AbstractHttpConfigurer::disable)
                //禁用session
                .sessionManagement(smc -> smc.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //访问异常处理
                .exceptionHandling(ehc -> ehc.accessDeniedHandler(restfulAccessDeniedHandler))
                //未授权异常处理
                .exceptionHandling(ehc -> ehc.authenticationEntryPoint(restfulAuthenticationEntryPoint))
                .headers(httpSecurityHeadersConfigurer -> {
                    //禁用缓存
                    httpSecurityHeadersConfigurer.cacheControl(HeadersConfigurer.CacheControlConfig::disable);
                    httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
                });
        // 添加JWT filter, 开启登录认证流程过滤器
        http.addFilterBefore(perAuthRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.userDetailsService(authUserDetailsService);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/js/**", "/webjars/**");
    }

}
