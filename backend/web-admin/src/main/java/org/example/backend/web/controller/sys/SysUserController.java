package org.example.backend.web.controller.sys;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.BaseParam;
import org.example.backend.common.model.R;
import org.example.backend.common.model.param.SysUserParam;
import org.example.backend.common.service.SysRoleService;
import org.example.backend.common.service.SysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/8/7 10:55
 */
@Slf4j
@RestController
@Api(value = "用户相关操作接口")
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;

    @ApiOperation(value = "查询用户列表")
    @PostMapping("/list")
    public R list(@RequestBody @Validated(BaseParam.list.class) SysUserParam param) {
        return R.data(sysUserService.pageList(param));
    }

    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public R addOrEdit(@RequestBody @Validated({BaseParam.add.class, BaseParam.edit.class}) SysUserParam param) {
        sysUserService.addOrEdit(param);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @GetMapping("/deleteById")
    public R deleteById(@RequestParam Integer id) {
        sysUserService.deleteById(id);
        return R.ok();
    }

    @ApiOperation(value = "重置密码")
    @GetMapping("/resetPassword")
    public R resetPassword(@RequestParam Integer id) {
        return R.ok().setData(sysUserService.resetPassword(id));
    }

    @ApiOperation(value = "查询全部角色列表")
    @GetMapping("/listAllRole")
    public R listAllRole() {
        return R.data(sysRoleService.findAllList());
    }

    @ApiOperation(value = "根据用户Id查询已关联角色")
    @GetMapping("/findRolesByUserId")
    public R findRolesByUserId(@RequestParam Integer userId) {
        return R.data(sysRoleService.findRolesByUserId(userId));
    }

    @ApiOperation(value = "用户关联角色")
    @PostMapping("/userAssocRole")
    public R userAssocRole(@RequestBody @Validated(SysUserParam.assocRole.class) SysUserParam sysUserParam) {
        sysRoleService.userAssocRole(sysUserParam);
        return R.ok();
    }

}
