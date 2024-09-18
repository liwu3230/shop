package org.example.backend.web.filter.manager;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.vo.LoginUserVo;
import org.example.backend.common.model.vo.SystemPermissions;
import org.example.backend.common.primary.entity.SystemAdmin;
import org.example.backend.common.primary.entity.SystemMenus;
import org.example.backend.common.service.SystemAdminService;
import org.example.backend.common.service.SystemMenuService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/17 21:39
 */
@Slf4j
@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Resource
    SystemAdminService systemAdminService;
    @Resource
    SystemMenuService systemMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemAdmin user = systemAdminService.selectUserByUserName(username);
        if (ObjectUtil.isNull(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        } else if (Objects.equals(user.getStatus(), 0)) {
            log.info("登录用户：{} 已被停用.", username);
            throw new UsernameNotFoundException("对不起，您的账号：" + username + " 已停用");
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SystemAdmin user) {
        List<Integer> roles = Stream.of(user.getRoles().split(",")).map(Integer::valueOf).toList();
        List<SystemMenus> menuList;
        if (roles.contains(1)) {// 超级管理员
            // 获取全部权限
            menuList = systemMenuService.getAllPermissions();
        } else {
            menuList = systemMenuService.findPermissionByUserId(user.getId());
        }
        menuList = menuList.stream().filter(e -> StrUtil.isNotEmpty(e.getController())).collect(Collectors.toList());
        List<SystemPermissions> permissionsList = menuList.stream().map(e -> {
            SystemPermissions permissions = new SystemPermissions();
            permissions.setId(e.getId());
            permissions.setPid(e.getPid());
            permissions.setName(e.getMenuName());
            permissions.setPath(e.getController());
            permissions.setSort(e.getSort());
            return permissions;
        }).collect(Collectors.toList());
        return new LoginUserVo(user, permissionsList);
    }

}
