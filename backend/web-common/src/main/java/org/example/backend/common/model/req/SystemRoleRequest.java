package org.example.backend.common.model.req;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 身份管理请求对象
 */
@Data
public class SystemRoleRequest implements Serializable {

    @ApiModelProperty(value = "角色id(添加时不填，修改时必填)")
    private Integer id;

    @ApiModelProperty(value = "身份管理名称", required = true)
    @NotNull(message = "身份管理名称不能为空")
    @Length(max = 32, message = "身份管理名称不能超过32个字符")
    private String roleName;

    @ApiModelProperty(value = "权限字符串(英文逗号拼接)", required = true)
    @NotNull(message = "权限不能为空")
    private String rules;

    @ApiModelProperty(value = "状态：0-关闭，1-正常", required = true)
    @NotNull(message = "状态不能为空")
    private Boolean status;
}
