package org.example.backend.common.model.req;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.example.backend.common.constants.RegularConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

@Data
public class SystemAdminUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "后台管理员表ID")
    @NotNull(message = "管理员id不能为空")
    private Integer id;

    @ApiModelProperty(value = "后台管理员账号", required = true)
    @NotNull(message = "后台管理员账号不能为空")
    @Length(max = 32, message = "账号长度不能超过32个字符")
    private String account;

    @ApiModelProperty(value = "后台管理员密码", required = true)
    @NotNull(message = "管理员密码不能为空")
    @Length(max = 32, message = "密码长度不能超过32个字符")
    private String pwd;

    @ApiModelProperty(value = "后台管理员姓名", required = true)
    @NotNull(message = "管理姓名不能为空")
    @Length(max = 16, message = "姓名长度不能超过16个字符")
    private String realName;

    @ApiModelProperty(value = "后台管理员权限(menus_id)")
    @NotBlank(message = "后台管理员权限不能为空")
    @Length(max = 128, message = "角色组合长度不能超过128个字符")
    private String roles;

    @ApiModelProperty(value = "后台管理员状态 1有效0无效")
    @NotNull(message = "status 字段不能为空")
    @Range(min = 0, max = 1, message = "未知的状态")
    private Boolean status;

    @ApiModelProperty(value = "手机号码")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = RegularConstants.PHONE_TWO, message = "请填写正确的手机号")
    private String phone;
}
