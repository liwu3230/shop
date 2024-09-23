package org.example.backend.common.security.filter;

import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.backend.common.model.R;
import org.example.backend.common.model.enums.TokenType;
import org.example.backend.common.security.config.SecurityProperties;
import org.example.backend.common.security.exception.AuthException;
import org.example.backend.common.security.service.AppUserDetailsService;
import org.example.backend.common.security.service.AuthUserDetailsService;
import org.example.backend.common.util.JwtTokenUtil;
import org.example.backend.common.util.T;
import org.example.backend.common.util.TokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @Description: 此过滤器在spring security filters之前，设置SecurityContext
 * @Author: liwu3
 * @Date: 2021/7/21 10:53
 */
@Slf4j
@Component
public class PerAuthRequestFilter extends OncePerRequestFilter {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Resource
    private AuthUserDetailsService authUserDetailsService;
    @Resource
    private SecurityProperties securityProperties;
    @Resource
    private AppUserDetailsService appUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        String[] ignoreUrls = securityProperties.getIgnoreUrls();
        if (T.isNotEmpty(ignoreUrls)) {
            for (String ignoreUrl : ignoreUrls) {
                if (antPathMatcher.match(ignoreUrl, path)) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }

        try {
            UserDetails userDetails;
            String token = TokenUtil.extractToken(request);
            if (StringUtils.isNotBlank(token)) {
                JwtTokenUtil.validateToken(token);
                TokenType tokenType = JwtTokenUtil.getTokenTypeByToken(token);
                if (tokenType == null) {
                    throw new AuthException("token is illegal");
                }
                Integer userId = JwtTokenUtil.getUserIdByToken(token);
                String userName = JwtTokenUtil.getUserNameByToken(token);
                if (tokenType == TokenType.WEB) {
                    userDetails = authUserDetailsService.loadUserByUsername(userName);
                } else if (tokenType == TokenType.APP) {
                    userDetails = appUserDetailsService.loadUserByUsername(String.valueOf(userId));
                } else {
                    throw new AuthException("token is illegal");
                }
                if (T.isNull(userDetails)) {
                    throw new AuthException("not find UserDetails!");
                }
                // 设置spring security上下文
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null,
                                userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (AuthException e) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(R.error401().toJSONString());
            return;
        }

        // 其他情况放开过滤
        filterChain.doFilter(request, response);
    }

    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvTnhrVjdjYXI3Y1FfZXZGWktMNmFTWmhvY21jIiwibmlja05hbWUiOiLlvq7kv6HnlKjmiLciLCJ0eXBlIjoiYXBwIiwidXNlck5hbWUiOiJvTnhrVjdjYXI3Y1FfZXZGWktMNmFTWmhvY21jIiwiZXhwIjoxNzE4Nzc5ODAxLCJ1c2VySWQiOm51bGwsImlhdCI6MTcxODE3NTAwMX0.dB_TsU9mD_E7ebDcIq-RFXyEjDAqKCjJSRFsNvut8iOLq11bjLEQVKpYso-zLcy3IAElYK2UQzKiMrgJvE9FUQ";
        Integer userId = JwtTokenUtil.getUserIdByToken(token);
        String userName = JwtTokenUtil.getUserNameByToken(token);
        TokenType tokenType = JwtTokenUtil.getTokenTypeByToken(token);
        System.out.println(userId);
        System.out.println(userName);
        System.out.println(tokenType);
    }

}
