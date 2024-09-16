package org.example.backend.common.security.filter;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.security.config.SecurityProperties;
import org.example.backend.common.security.entity.SecurityAppUser;
import org.example.backend.common.security.entity.SecurityClientDetails;
import org.example.backend.common.security.entity.SecurityUser;
import org.example.backend.common.service.SysUserService;
import org.example.backend.common.utils.T;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 自定义权限投票器
 * @Author: liwu3
 * @Date: 2021/9/9 17:52
 */
@Slf4j
@Component
public class RestfulAccessDecisionProcessor implements AccessDecisionVoter<FilterInvocation> {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SecurityProperties securityProperties;

    @Override
    public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {
        String requestUrl = object.getHttpRequest().getServletPath();
//        String method = object.getRequest().getMethod();
        String[] ignoreUrls = securityProperties.getIgnoreUrls();
        if (T.isNotEmpty(ignoreUrls)) {
            for (String ignoreUrl : ignoreUrls) {
                if (antPathMatcher.match(ignoreUrl, requestUrl)) {
                    return ACCESS_GRANTED;
                }
            }
        }
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (principal instanceof SecurityUser) {
            return authorizeWithSysUser(principal, requestUrl);
        } else if (principal instanceof SecurityAppUser) {
            return commonAuthorize(authorities, requestUrl);
        } else if (principal instanceof SecurityClientDetails) {
            return commonAuthorize(authorities, requestUrl);
        }
        return ACCESS_DENIED;
    }

    private int commonAuthorize(Collection<? extends GrantedAuthority> authorities, String requestUrl) {
        if (T.isEmpty(authorities)) {
            return ACCESS_DENIED;
        }
        for (GrantedAuthority authority : authorities) {
            String auth = authority.getAuthority();
            if (antPathMatcher.match(auth, requestUrl)) {
                return ACCESS_GRANTED;
            }
        }
        return ACCESS_DENIED;
    }

    private int authorizeWithSysUser(Object principal, String requestUrl) {
        SecurityUser securityUser = (SecurityUser) principal;
        if (T.nonNull(securityUser) && Objects.equals(securityUser.getSuperAdmin(), true)) {
            return ACCESS_GRANTED;
        }
        Map<String, Set<Integer>> urlRoleMap = sysUserService.loadUrlPermissions();
        Set<Integer> allowRoleIds = Sets.newHashSet();
        boolean isMatch = false;
        if (T.isNotEmpty(urlRoleMap)) {
            for (Map.Entry<String, Set<Integer>> entry : urlRoleMap.entrySet()) {
                if (antPathMatcher.match(entry.getKey(), requestUrl)) {
                    isMatch = true;
                    allowRoleIds = entry.getValue();
                    break;
                }
            }
        }
        if (!isMatch) {
            //没有匹配到需要鉴权的URL，弃权
            return ACCESS_ABSTAIN;
        }
        List<String> allPerms = allowRoleIds.stream().map(String::valueOf).collect(Collectors.toList());
        List<String> userPerms = securityUser.getPermissionList();
        boolean disjoint = Collections.disjoint(allPerms, userPerms);
        if (!disjoint) {
            return ACCESS_GRANTED;
        } else {
            return ACCESS_DENIED;
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

}
