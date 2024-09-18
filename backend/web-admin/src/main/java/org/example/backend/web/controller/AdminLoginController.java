package org.example.backend.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.R;
import org.example.backend.common.model.req.SystemAdminLoginRequest;
import org.example.backend.common.model.resp.SystemLoginResponse;
import org.example.backend.common.service.AdminLoginService;
import org.example.backend.common.utils.T;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * 管理端登录服务
 */
@Slf4j
@RestController
@RequestMapping("api/admin")
@Api(tags = "管理端登录服务")
public class AdminLoginController {

    @Resource
    private AdminLoginService adminLoginService;

    @ApiOperation(value = "PC登录")
    @PostMapping(value = "/login", produces = "application/json")
    public R SystemAdminLogin(@RequestBody @Validated SystemAdminLoginRequest systemAdminLoginRequest, HttpServletRequest request) {
        String ip = T.getIpAddr(request);
        SystemLoginResponse systemAdminResponse = adminLoginService.login(systemAdminLoginRequest, ip);
        return R.data(systemAdminResponse, "login success");
    }

    @PreAuthorize("hasAuthority('admin:logout')")
//    @ApiOperation(value = "PC登出")
    @GetMapping(value = "/logout")
    public R SystemAdminLogout() {
        adminLoginService.logout();
        return R.ok("logout success");
    }

    @PreAuthorize("hasAuthority('admin:info')")
//    @ApiOperation(value = "获取用户详情")
    @GetMapping(value = "/getAdminInfoByToken")
    public R getAdminInfo() {
        return R.data(adminLoginService.getInfoByToken());
    }

    /**
     * 获取登录页图片
     *
     * @return Map<String, Object>
     */
//    @ApiOperation(value = "获取登录页图片")
    @RequestMapping(value = "/getLoginPic", method = RequestMethod.GET)
    public R getLoginPic() {
        return R.data(adminLoginService.getLoginPic());
    }

    /**
     * 获取管理员可访问目录
     */
    @PreAuthorize("hasAuthority('admin:login:menus')")
//    @ApiOperation(value = "获取管理员可访问目录")
    @RequestMapping(value = "/getMenus", method = RequestMethod.GET)
    public R getMenus() {
        return R.data(adminLoginService.getMenus());
    }

}
