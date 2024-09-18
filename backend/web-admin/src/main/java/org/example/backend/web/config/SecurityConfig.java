package org.example.backend.web.config;

import jakarta.annotation.Resource;
import org.example.backend.web.filter.JwtAuthTokenFilter;
import org.example.backend.web.filter.manager.AuthUserDetailsService;
import org.example.backend.web.filter.manager.CustomAccessDeniedHandler;
import org.example.backend.web.filter.manager.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
 * @Date: 2024/9/17 22:55
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Resource
    AuthUserDetailsService authUserDetailsService;
    @Resource
    SecurityProperties securityProperties;
    @Resource
    CustomAccessDeniedHandler customAccessDeniedHandler;
    @Resource
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    /**
     * token认证过滤器
     */
    @Bean
    public JwtAuthTokenFilter jwtAuthTokenFilter() {
        return new JwtAuthTokenFilter(authUserDetailsService);
    }

    @Bean
    protected AuthenticationManager AuthenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(authUserDetailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }

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
                .exceptionHandling(ehc -> ehc.accessDeniedHandler(customAccessDeniedHandler))
                //未授权异常处理
                .exceptionHandling(ehc -> ehc.authenticationEntryPoint(customAuthenticationEntryPoint))
                .headers(httpSecurityHeadersConfigurer -> {
                    //禁用缓存
                    httpSecurityHeadersConfigurer.cacheControl(HeadersConfigurer.CacheControlConfig::disable);
                    httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
                });
        // 添加JWT filter, 开启登录认证流程过滤器
        http.addFilterBefore(jwtAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/js/**", "/webjars/**");
    }

}
