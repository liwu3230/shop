package org.example.backend.common.service;

import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysOperateLogDto;
import org.example.backend.common.model.param.SysOperateLogParam;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/3 19:19
 */
public interface SysOperateLogService {

    Page<SysOperateLogDto> pageList(SysOperateLogParam param);

    void addLog(String opType, String subject, String subjectExt, String content);

}
