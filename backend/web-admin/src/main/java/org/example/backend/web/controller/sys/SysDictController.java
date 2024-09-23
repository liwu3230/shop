package org.example.backend.web.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.BaseParam;
import org.example.backend.common.model.R;
import org.example.backend.common.model.param.SysDictParam;
import org.example.backend.common.service.SysDictService;
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
@Api(value = "字典相关操作接口")
@RequestMapping("/sys/dict")
public class SysDictController {

    @Resource
    private SysDictService sysDictService;

    @ApiOperation(value = "分页查询字典列表")
    @PostMapping("/list")
    public R list(@RequestBody @Validated(BaseParam.list.class) SysDictParam param) {
        return R.data(sysDictService.pageList(param));
    }

    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public R addOrEdit(@RequestBody @Validated({BaseParam.add.class, BaseParam.edit.class}) SysDictParam param) {
        sysDictService.addOrEdit(param);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @GetMapping("/deleteById")
    public R deleteById(@RequestParam Integer id) {
        sysDictService.deleteById(id);
        return R.ok();
    }

}
