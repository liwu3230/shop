package org.example.backend.common.service;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.enums.TokenType;
import org.example.backend.common.model.req.SystemAdminLoginRequest;
import org.example.backend.common.model.resp.MenusResponse;
import org.example.backend.common.model.resp.SystemAdminResponse;
import org.example.backend.common.model.resp.SystemLoginResponse;
import org.example.backend.common.model.vo.LoginUserVo;
import org.example.backend.common.model.vo.MenuTree;
import org.example.backend.common.model.vo.SystemPermissions;
import org.example.backend.common.primary.base.dao.SystemAdminDao;
import org.example.backend.common.primary.entity.SystemAdmin;
import org.example.backend.common.primary.entity.SystemMenus;
import org.example.backend.common.utils.JwtTokenUtil;
import org.example.backend.common.utils.SecurityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/16 22:21
 */
@Service
@Slf4j
public class AdminLoginService {

    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    SystemAdminDao systemAdminDao;
    @Resource
    SystemConfigService systemConfigService;
    @Resource
    SystemMenuService systemMenuService;

    /**
     * PC登录
     */
    public SystemLoginResponse login(SystemAdminLoginRequest systemAdminLoginRequest, String ip) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(systemAdminLoginRequest.getAccount(), systemAdminLoginRequest.getPwd()));
        } catch (AuthenticationException e) {
            if (e instanceof BadCredentialsException) {
                throw new RuntimeException("用户不存在或密码错误");
            }
            throw new RuntimeException(e.getMessage());
        }
        LoginUserVo loginUser = (LoginUserVo) authentication.getPrincipal();
        SystemAdmin systemAdmin = loginUser.getUser();

        String token = JwtTokenUtil.generateToken(TokenType.WEB,
                loginUser.getUser().getId(), loginUser.getUser().getAccount(),
                loginUser.getUser().getRealName());

        SystemLoginResponse systemAdminResponse = new SystemLoginResponse();
        systemAdminResponse.setToken(token);
        BeanUtils.copyProperties(systemAdmin, systemAdminResponse);

        //更新最后登录信息
        systemAdmin.setLoginCount(systemAdmin.getLoginCount() + 1);
        systemAdmin.setLastIp(ip);
        systemAdminDao.updateByPrimaryKey(systemAdmin);
        return systemAdminResponse;
    }

    /**
     * 用户登出
     */
    public Boolean logout() {
        LoginUserVo loginUserVo = SecurityUtil.getLoginUserVo();
        return true;
    }

    /**
     * 获取登录页图片
     */
    public Map<String, Object> getLoginPic() {
        Map<String, Object> map = new HashMap<>();
//        //背景图
//        map.put("backgroundImage", systemConfigService.getValueByKey(SysConfigConstants.CONFIG_KEY_ADMIN_LOGIN_BACKGROUND_IMAGE));
//        //logo
//        map.put("logo", systemConfigService.getValueByKey(SysConfigConstants.CONFIG_KEY_ADMIN_LOGIN_LOGO_LEFT_TOP));
//        map.put("loginLogo", systemConfigService.getValueByKey(SysConfigConstants.CONFIG_KEY_ADMIN_LOGIN_LOGO_LOGIN));
        return map;
    }

    /**
     * 获取管理员可访问目录
     */
    public List<MenusResponse> getMenus() {
        LoginUserVo loginUserVo = SecurityUtil.getLoginUserVo();
        List<String> roleList = Stream.of(loginUserVo.getUser().getRoles().split(",")).collect(Collectors.toList());
        List<SystemMenus> menuList;
        if (roleList.contains("1")) {// 超管
            menuList = systemMenuService.findAllCatalogue();
        } else {
            menuList = systemMenuService.getMenusByUserId(loginUserVo.getUser().getId());
        }
        // 组装前端对象
        List<MenusResponse> responseList = menuList.stream().map(e -> {
            MenusResponse response = new MenusResponse();
            BeanUtils.copyProperties(e, response);
            return response;
        }).collect(Collectors.toList());

        MenuTree menuTree = new MenuTree(responseList);
        return menuTree.buildTree();
    }

    /**
     * 根据Token获取对应用户信息
     */
    public SystemAdminResponse getInfoByToken() {
        LoginUserVo loginUserVo = SecurityUtil.getLoginUserVo();
        SystemAdmin systemAdmin = loginUserVo.getUser();
        SystemAdminResponse systemAdminResponse = new SystemAdminResponse();
        BeanUtils.copyProperties(systemAdmin, systemAdminResponse);
        List<String> roleList = Stream.of(systemAdmin.getRoles().split(",")).collect(Collectors.toList());
        List<String> permList = CollUtil.newArrayList();
        if (roleList.contains("1")) {
            permList.add("*:*:*");
        } else {
            permList = loginUserVo.getPermissions().stream().map(SystemPermissions::getPath).collect(Collectors.toList());
        }
        systemAdminResponse.setPermissionsList(permList);
        return systemAdminResponse;
    }

}
