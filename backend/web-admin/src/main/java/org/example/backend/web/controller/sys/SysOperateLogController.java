package org.example.backend.web.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.BaseParam;
import org.example.backend.common.model.R;
import org.example.backend.common.model.param.SysOperateLogParam;
import org.example.backend.common.service.SysOperateLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/28 12:59
 */
@Slf4j
@RestController
@Api(value = "操作日志相关操作接口")
@RequestMapping("/sys/operateLog")
public class SysOperateLogController {

    @Resource
    private SysOperateLogService sysOperateLogService;

    @ApiOperation(value = "分页查询操作日志列表")
    @PostMapping("/list")
    public R list(@RequestBody @Validated(BaseParam.list.class) SysOperateLogParam param) {
        return R.data(sysOperateLogService.pageList(param));
    }

}
