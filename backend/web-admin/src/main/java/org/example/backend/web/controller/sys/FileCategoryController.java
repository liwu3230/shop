package org.example.backend.web.controller.sys;

import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.BaseParam;
import org.example.backend.common.model.R;
import org.example.backend.common.model.param.SysAttachmentCategoryParam;
import org.example.backend.common.service.FileCategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 15:27
 */
@Slf4j
@RestController
@RequestMapping("/fileCategory")
public class FileCategoryController {

    @Resource
    FileCategoryService fileCategoryService;

    @ApiOperation(value = "查询附件分类树")
    @RequestMapping("/tree")
    public R groupList() {
        return R.data(fileCategoryService.listTree());
    }

    @ApiOperation(value = "保存附件分类")
    @PostMapping("/save")
    public R save(@RequestBody @Validated({BaseParam.add.class}) SysAttachmentCategoryParam req) {
        fileCategoryService.saveOrUpdate(req);
        return R.ok();
    }

    @ApiOperation(value = "编辑附件分类")
    @PostMapping("/update")
    public R update(@RequestBody @Validated({BaseParam.edit.class}) SysAttachmentCategoryParam req) {
        fileCategoryService.saveOrUpdate(req);
        return R.ok();
    }

    @ApiOperation(value = "删除附件分类")
    @RequestMapping("/deleteById")
    public R deleteById(@RequestParam Integer id) {
        fileCategoryService.deleteById(id);
        return R.ok();
    }

}
