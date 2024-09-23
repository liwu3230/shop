package org.example.backend.web.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.BaseParam;
import org.example.backend.common.model.R;
import org.example.backend.common.model.dto.SysSimpleUserDto;
import org.example.backend.common.model.enums.TokenType;
import org.example.backend.common.model.param.LoginParam;
import org.example.backend.common.model.param.SysMenuParam;
import org.example.backend.common.primary.entity.SysUser;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.SysCityService;
import org.example.backend.common.service.SysDictService;
import org.example.backend.common.service.SysMenuService;
import org.example.backend.common.service.SysUserService;
import org.example.backend.common.util.AESUtil;
import org.example.backend.common.util.JwtTokenUtil;
import org.example.backend.common.util.T;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:00
 */
@Slf4j
@RestController
@Api(value = "通用操作接口")
@RequestMapping("/common")
public class CommonController {

    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private SysDictService sysDictService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysCityService sysCityService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public R login(@RequestBody @Validated LoginParam loginParam) {
        if (T.isBlank(loginParam.getUserName())) {
            return R.error("用户名不能为空！");
        }
        if (T.isBlank(loginParam.getPassword())) {
            return R.error("密码不能为空！");
        }
        SysUser existUser = sysUserService.findByUserName(loginParam.getUserName());
        if (T.isNull(existUser)) {
            return R.error("用户名或密码错误！");
        }
        if (!Objects.equals(existUser.getIsAdmin(), 1)) {
            if (!Objects.equals(existUser.getStatus(), 0)) {
                return R.error("账号状态异常，请联系管理员！");
            }
            if (T.nonNull(existUser.getExpireTime()) && T.LT(existUser.getExpireTime().getTime(), System.currentTimeMillis())) {
                return R.error("账号已过期，请联系管理员！");
            }
        }

        if (Objects.equals(loginParam.getPassword(), AESUtil.decrypt(existUser.getPassword()))) {
            String accessToken = JwtTokenUtil.generateToken(TokenType.WEB, existUser.getId(), existUser.getUserName(), existUser.getNickName());
            return R.data(accessToken);
        }
        return R.error("用户名或密码错误！");
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/updatePassword")
    public R updatePassword(@RequestBody @Validated LoginParam loginParam) {
        Integer userId = AuthenticationUtil.getUserId();
        SysUser sysUser = null;
        if (T.nonNull(userId)) {
            sysUser = sysUserService.findById(userId);
        } else if (T.isNotBlank(loginParam.getUserName())) {
            sysUser = sysUserService.findByUserName(loginParam.getUserName());
        }
        if (T.isNull(sysUser)) {
            return R.error("账号不存在！");
        }
        if (T.isBlank(loginParam.getOldPassword())) {
            return R.error("旧密码不能为空！");
        }
        if (T.isBlank(loginParam.getPassword())) {
            return R.error("新密码不能为空！");
        }
        if (loginParam.getPassword().length() < 8 || loginParam.getPassword().length() > 16) {
            return R.error("新密码长度需在8~16个字符！");
        }
        if (Objects.equals(loginParam.getOldPassword(), loginParam.getPassword())) {
            return R.error("新旧密码不能一致！");
        }
        if (!Objects.equals(loginParam.getOldPassword(), AESUtil.decrypt(sysUser.getPassword()))) {
            return R.error("旧密码错误！");
        }
        sysUserService.updatePassword(sysUser.getId(), loginParam.getPassword());
        return R.ok();
    }

    @ApiOperation(value = "查询所有用户列表")
    @GetMapping("/getAllSimple")
    public R getAllSimple() {
        String curUserName = AuthenticationUtil.getUserName();
        List<SysUser> list = sysUserService.findAllList();
        List<SysSimpleUserDto> results = new ArrayList<>();
        list.forEach(user -> {
            SysSimpleUserDto simpleUser = new SysSimpleUserDto();
            simpleUser.setUserId(user.getId());
            simpleUser.setUserName(user.getUserName());
            simpleUser.setNickName(user.getNickName());
            simpleUser.setLabelName(user.getNickName() + "(" + user.getUserName() + ")");
            results.add(simpleUser);
        });
        //将当前用户放在最前面
        Iterator<SysSimpleUserDto> iterator = results.iterator();
        SysSimpleUserDto currentUser = null;
        while (iterator.hasNext()) {
            SysSimpleUserDto simpleUserDto = iterator.next();
            if (Objects.equals(simpleUserDto.getUserName(), curUserName)) {
                currentUser = simpleUserDto;
                iterator.remove();
            }
        }
        if (Objects.nonNull(currentUser)) {
            results.add(0, currentUser);
        }
        return R.data(results);
    }

    @ApiOperation(value = "查询当前用户信息")
    @GetMapping("/getCurrentUser")
    public R getCurrentUser() {
        Integer userId = AuthenticationUtil.getUserId();
        return R.ok().setData(sysUserService.findById(userId));
    }

    @ApiOperation(value = "查询当前用户拥有的按钮权限")
    @GetMapping("/buttonAbility")
    public R buttonAbility() {
        Integer userId = AuthenticationUtil.getUserId();
        return R.data(sysMenuService.findButtonPermsByUser(userId));
    }

    @ApiOperation(value = "查询当前用户拥有的菜单列表")
    @GetMapping("/menu")
    public R menu() {
        Integer userId = AuthenticationUtil.getUserId();
        return R.data(sysMenuService.findMenuByUser(userId));
    }

    @ApiOperation(value = "查询面包屑列表")
    @GetMapping("/findBreadcrumb")
    public R findBreadcrumb() {
        Integer userId = AuthenticationUtil.getUserId();
        return R.data(sysMenuService.findBreadcrumbByUser(userId));
    }

    @ApiOperation(value = "查询字典列表")
    @GetMapping("/findDictByCode")
    public R findDictByCode(@RequestParam String code) {
        return R.data(sysDictService.findByCode(code));
    }

    @ApiOperation(value = "查询菜单树")
    @PostMapping("/queryMenuTree")
    public R listTree(@RequestBody @Validated(BaseParam.list.class) SysMenuParam param) {
        return R.data(sysMenuService.listTree(param));
    }

    @ApiOperation(value = "查询城市树")
    @RequestMapping("/listCityTree")
    public R listCityTree() {
        return R.data(sysCityService.listTree(true));
    }

    @RequestMapping("/downloadTemplate")
    public void downloadTemplate(@RequestParam String name, HttpServletResponse response) throws Exception {
        String path = "excel_template/" + name + ".xlsx";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            response.setStatus(404);
            return;
        }
        String fileName = URLEncoder.encode(name, "UTF-8").replaceAll("\\+", "%20");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Expose-Headers", "Content-disposition");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        byte[] buffer = new byte[4 * 1024];
        try (
                OutputStream outputStream = response.getOutputStream();
        ) {
            int len;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
            outputStream.flush();
        } catch (Exception e) {
            log.error("download file error", e);
        }
    }
}
