package org.example.backend.common.model.param;

import lombok.Data;
import org.example.backend.common.model.BaseParam;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/12 17:32
 */
@Data
public class SysRoleParam extends BaseParam {

    @NotNull(message = "id不能为空，请检查id参数", groups = {assocUser.class, grantMenu.class, delete.class, detail.class})
    private Integer id;

    @NotBlank(message = "角色名称不能为空，请检查name参数", groups = {add.class, edit.class})
    private String name;

    @NotNull(message = "状态不能为空，请检查status参数", groups = {add.class, edit.class})
    @Min(value = 0, message = "状态格式错误，请检查status参数", groups = {add.class, edit.class})
    @Max(value = 2, message = "状态格式错误，请检查status参数", groups = {add.class, edit.class})
    private Integer status;

    private String remark;

    private String desc;

    @NotNull(message = "授权菜单不能为空，请检查grantMenuIdList参数", groups = {grantMenu.class})
    private List<Integer> grantMenuIdList;

    @NotNull(message = "授权用户ID不能为空，请检查assocUserNames参数", groups = {assocUser.class})
    private List<Integer> assocUserIds;

    /**
     * 参数校验分组：角色关联用户
     */
    public @interface assocUser {
    }

    /**
     * 参数校验分组：授权菜单
     */
    public @interface grantMenu {
    }

}
