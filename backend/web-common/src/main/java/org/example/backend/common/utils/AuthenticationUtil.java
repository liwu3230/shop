package org.example.backend.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

//    public static Boolean isSuperAdmin() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!Objects.isNull(authentication) && authentication.getPrincipal() instanceof SecurityUser) {
//            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
//            return Objects.equals(securityUser.getSysUser().getIsAdmin(), 1);
//        }
//        return false;
//    }
//
//    public static Integer getUserId() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (Objects.isNull(authentication)) {
//            return null;
//        }
//        if (authentication.getPrincipal() instanceof SecurityUser) {
//            SecurityUser securityPrincipal = (SecurityUser) authentication.getPrincipal();
//            return securityPrincipal.getSysUser().getId();
//        } else if (authentication.getPrincipal() instanceof SecurityAppUser) {
//            SecurityAppUser securityPrincipal = (SecurityAppUser) authentication.getPrincipal();
//            return securityPrincipal.getAppUser().getId();
//        }
//        return null;
//    }
//
//    public static Integer getAppUserId() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (Objects.isNull(authentication)) {
//            return null;
//        }
//        if (authentication.getPrincipal() instanceof SecurityAppUser) {
//            SecurityAppUser securityPrincipal = (SecurityAppUser) authentication.getPrincipal();
//            return securityPrincipal.getAppUser().getId();
//        }
//        return null;
//    }
//
//    public static TokenType getTokenType() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (Objects.isNull(authentication)) {
//            return null;
//        }
//        if (authentication.getPrincipal() instanceof SecurityUser) {
//            return TokenType.WEB;
//        } else if (authentication.getPrincipal() instanceof SecurityAppUser) {
//            return TokenType.APP;
//        }
//        return null;
//    }
//
//    public static String getUserName() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (Objects.isNull(authentication)) {
//            return "";
//        }
//        if (authentication.getPrincipal() instanceof SecurityUser) {
//            SecurityUser securityPrincipal = (SecurityUser) authentication.getPrincipal();
//            return securityPrincipal.getSysUser().getUserName();
//        } else if (authentication.getPrincipal() instanceof SecurityAppUser) {
//            SecurityAppUser securityPrincipal = (SecurityAppUser) authentication.getPrincipal();
//            return securityPrincipal.getAppUser().getOpenId();
//        }
//        return "";
//    }


}
