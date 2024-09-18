package org.example.backend.web.filter.manager;

import cn.hutool.core.util.ObjectUtil;
import org.example.backend.common.model.vo.LoginUserVo;
import org.example.backend.common.utils.AESUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 自定义验证（admin登录）
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private AuthUserDetailsService authUserDetailsService;

    public CustomAuthenticationProvider(AuthUserDetailsService authUserDetailsService) {
        this.authUserDetailsService = authUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        //以下自定义方法，判断是否登录成功
        LoginUserVo userDetails = (LoginUserVo) authUserDetailsService.loadUserByUsername(name);
        if (ObjectUtil.isNull(userDetails)) {
            throw new RuntimeException("用户名不存在");
        }
        //AES加密获取真正密码
        String encryptPassword = AESUtil.encrypt(password);
        if (!userDetails.getUser().getPwd().equals(encryptPassword)) {
            throw new RuntimeException("账号或者密码不正确");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //确保authentication能转成该类
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
