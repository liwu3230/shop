package org.example.backend.common.model.param;

import lombok.Data;
import org.example.backend.common.model.BaseParam;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/12 17:32
 */
@Data
public class SysOperateLogParam extends BaseParam {

    private String opType;

    private String subject;

    private String subjectExt;

    private String content;

    private String userId;

    private String userName;

}
