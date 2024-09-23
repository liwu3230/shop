package org.example.backend.common.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.backend.common.aspect.DateTime;
import org.example.backend.common.model.BaseParam;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/12 17:32
 */
@Data
@ApiModel
public class SysUserParam extends BaseParam {

    @NotNull(message = "id不能为空，请检查id参数", groups = {delete.class, detail.class, assocRole.class})
    private Integer id;

    @NotBlank(message = "用户名称不能为空，请检查userName参数", groups = {add.class})
    @ApiModelProperty(value = "用户名")
    private String userName;

    private String nickName;

    @ApiModelProperty(value = "状态(0正常 1停用 2删除)")
    private Integer status;

    private Integer deptId;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别 0：未知、1：男、2：女
     */
    private Integer gender;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    /**
     * 国家
     */
    private String country;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 过期时间
     */
    @DateTime(message = "格式错误，正确格式为：yyyy-MM-dd HH:mm:ss")
    private String expireTime;

    @NotNull(message = "授权角色不能为空，请检查grantRoleIdList参数", groups = {assocRole.class})
    private List<Integer> grantRoleIdList;

    /**
     * 参数校验分组：用户关联角色
     */
    public @interface assocRole {
    }

}
