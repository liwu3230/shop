package org.example.backend.common.security.service;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.security.entity.SecurityUser;
import org.example.backend.common.service.SysUserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 10:45
 */
@Slf4j
@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public SecurityUser loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByUserName(userName);
        List<String> permissions = sysUserService.queryRoleIdsByUserName(userName);
        return new SecurityUser(user, permissions, Objects.equals(user.getIsAdmin(), 1));
    }

}
