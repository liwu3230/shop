package org.example.backend.common.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.backend.common.model.BaseParam;

@Data
public class SystemRoleSearchRequest extends BaseParam {

    @ApiModelProperty(value = "身份管理名称")
    private String roleName;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
