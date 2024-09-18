package org.example.backend.web.filter;

import org.apache.commons.lang3.StringUtils;
import org.example.backend.common.model.enums.TokenType;
import org.example.backend.common.model.vo.LoginUserVo;
import org.example.backend.common.utils.AuthException;
import org.example.backend.common.utils.JwtTokenUtil;
import org.example.backend.common.utils.TokenUtil;
import org.example.backend.web.filter.manager.AuthUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token过滤器 验证token有效性
 */
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    private AuthUserDetailsService authUserDetailsService;

    public JwtAuthTokenFilter(AuthUserDetailsService authUserDetailsService) {
        this.authUserDetailsService = authUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = TokenUtil.extractToken(request);
        if (StringUtils.isNotBlank(token)) {
            JwtTokenUtil.validateToken(token);
            TokenType tokenType = JwtTokenUtil.getTokenTypeByToken(token);
            if (tokenType == null) {
                throw new AuthException("token is illegal");
            }
            String userName = JwtTokenUtil.getUserNameByToken(token);
            if (tokenType != TokenType.WEB) {
                throw new AuthException("token is illegal");
            }
            LoginUserVo loginUser = (LoginUserVo) authUserDetailsService.loadUserByUsername(userName);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser, null,
                            loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // 将authentication信息放入到上下文对象中
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
