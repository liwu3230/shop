package org.example.backend.common.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.backend.common.model.BaseParam;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/17 13:31
 */
@Data
public class SystemAdminRequest extends BaseParam {

    @ApiModelProperty(value = "后台管理员姓名")
    private String realName;

    @ApiModelProperty(value = "后台管理员权限(menus_id)")
    private String roles;

    @ApiModelProperty(value = "后台管理员状态 1有效0无效")
    private Boolean status;

}
