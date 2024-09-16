package org.example.backend.common.security.config;

import org.example.backend.common.security.filter.PerAuthRequestFilter;
import org.example.backend.common.security.filter.RestfulAccessDecisionProcessor;
import org.example.backend.common.security.filter.RestfulAccessDeniedHandler;
import org.example.backend.common.security.filter.RestfulAuthenticationEntryPoint;
import org.example.backend.common.security.service.AuthUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 10:41
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

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
    @Resource
    private RestfulAccessDecisionProcessor restfulAccessDecisionProcessor;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        //开启跨域访问
        httpSecurity.cors();
        //不使用默认退出，自定义退出
        httpSecurity.logout().disable();
        //前置过滤器,设置SecurityContext
        httpSecurity.addFilterBefore(perAuthRequestFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.userDetailsService(authUserDetailsService);
        //放开部分资源的权限校验
        for (String pattern : securityProperties.getIgnoreUrls()) {
            httpSecurity.authorizeRequests().antMatchers(pattern).permitAll();
        }
        //使用自定义的accessDecisionManager
        httpSecurity.authorizeRequests().anyRequest().authenticated()
                .accessDecisionManager(accessDecisionManager());
        // 添加未登录与权限不足异常处理器
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restfulAuthenticationEntryPoint);
        //关闭Session机制
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //禁用页面缓存
        httpSecurity.headers()
                .frameOptions().disable()
                .cacheControl();
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        // 构造一个新的AccessDecisionManager 放入两个决断器：自定义权限投票器+配置文件投票器WebExpressionVoter
        List<AccessDecisionVoter<?>> decisionVoters = Arrays.asList(new WebExpressionVoter(), restfulAccessDecisionProcessor);
        //这里使用一票反对策略 AffirmativeBased：一票通过(默认); UnanimousBased：一票反对; ConsensusBased：少数票服从多数票
        return new UnanimousBased(decisionVoters);
    }

}
