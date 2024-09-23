package org.example.backend.web.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.BaseParam;
import org.example.backend.common.model.R;
import org.example.backend.common.model.param.SysMenuParam;
import org.example.backend.common.service.SysMenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/28 12:59
 */
@Slf4j
@RestController
@Api(value = "菜单相关操作接口")
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    @ApiOperation(value = "查询列表(树)")
    @PostMapping("/listTree")
    public R listTree(@RequestBody @Validated(BaseParam.list.class) SysMenuParam param) {
        return R.data(sysMenuService.listTree(param));
    }

    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public R addOrEdit(@RequestBody @Validated({BaseParam.add.class, BaseParam.edit.class}) SysMenuParam param) {
        sysMenuService.addOrEdit(param);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @GetMapping("/deleteById")
    public R deleteById(@RequestParam Integer id) {
        sysMenuService.deleteById(id);
        return R.ok();
    }

}
