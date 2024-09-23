package org.example.backend.web.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.BaseParam;
import org.example.backend.common.model.R;
import org.example.backend.common.model.param.SysRoleParam;
import org.example.backend.common.primary.entity.SysUser;
import org.example.backend.common.service.SysRoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/28 12:59
 */
@Slf4j
@RestController
@Api(value = "角色相关操作接口")
@RequestMapping("/sys/role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @ApiOperation(value = "分页查询角色列表")
    @PostMapping("/list")
    public R pageList(@RequestBody @Validated(BaseParam.list.class) SysRoleParam param) {
        return R.data(sysRoleService.pageList(param));
    }

    @ApiOperation(value = "根据角色id查询已关联菜单id列表")
    @GetMapping("/findMenuIdsByRoleId")
    public R findMenuIdsByRoleId(@RequestParam Integer roleId) {
        return R.data(sysRoleService.findMenuIdsByRoleId(roleId));
    }

    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public R addOrEdit(@RequestBody @Validated({BaseParam.add.class, BaseParam.edit.class}) SysRoleParam param) {
        sysRoleService.addOrEdit(param);
        return R.ok();
    }

    @ApiOperation(value = "授权菜单")
    @PostMapping("/grantMenu")
    public R grantMenu(@RequestBody @Validated(SysRoleParam.grantMenu.class) SysRoleParam sysRoleParam) {
        sysRoleService.grantMenu(sysRoleParam);
        return R.ok();
    }

    @ApiOperation(value = "根据角色id查询已关联用户列表")
    @GetMapping("/findUserListByRoleId")
    public R findUserListByRoleId(@RequestParam Integer roleId) {
        List<SysUser> userList = sysRoleService.findUserListByRoleId(roleId);
        return R.data(userList);
    }

    @ApiOperation(value = "查询用户列表")
    @PostMapping("/listUser")
    public void listUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("/sys/user/list").forward(request, response);
    }

    @ApiOperation(value = "角色关联用户")
    @PostMapping("/roleAssocUser")
    public R roleAssocUser(@RequestBody @Validated(SysRoleParam.assocUser.class) SysRoleParam sysUserParam) {
        sysRoleService.roleAssocUser(sysUserParam);
        return R.ok();
    }

    @ApiOperation(value = "取消角色关联用户")
    @PostMapping("/roleCancelUser")
    public R roleCancelUser(@RequestBody @Validated(SysRoleParam.assocUser.class) SysRoleParam sysUserParam) {
        sysRoleService.roleCancelUser(sysUserParam);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @GetMapping("/deleteById")
    public R deleteById(@RequestParam Integer id) {
        sysRoleService.deleteById(id);
        return R.ok();
    }

}
