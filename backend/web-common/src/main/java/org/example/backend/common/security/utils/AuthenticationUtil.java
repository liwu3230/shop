package org.example.backend.common.security.utils;

import org.example.backend.common.model.enums.TokenType;
import org.example.backend.common.security.entity.SecurityAppUser;
import org.example.backend.common.security.entity.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/8/20 11:54
 */
public class AuthenticationUtil {

    /**
     * 获取SpringSecurity上下文中认证信息
     *
     * @return
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Boolean isSuperAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!Objects.isNull(authentication) && authentication.getPrincipal() instanceof SecurityUser securityUser) {
            return Objects.equals(securityUser.getSysUser().getIsAdmin(), 1);
        }
        return false;
    }

    public static Integer getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication)) {
            return null;
        }
        if (authentication.getPrincipal() instanceof SecurityUser securityPrincipal) {
            return securityPrincipal.getSysUser().getId();
        }
        return null;
    }

    public static TokenType getTokenType() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication)) {
            return null;
        }
        if (authentication.getPrincipal() instanceof SecurityUser) {
            return TokenType.WEB;
        } else if (authentication.getPrincipal() instanceof SecurityAppUser) {
            return TokenType.APP;
        }
        return null;
    }

    public static String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication)) {
            return "";
        }
        if (authentication.getPrincipal() instanceof SecurityUser securityPrincipal) {
            return securityPrincipal.getSysUser().getUserName();
        }
        return "";
    }

    public static List<String> getRoleIds() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!Objects.isNull(authentication) && authentication.getPrincipal() instanceof SecurityUser securityUser) {
            return securityUser.getPermissionList();
        }
        return Collections.emptyList();
    }

}
