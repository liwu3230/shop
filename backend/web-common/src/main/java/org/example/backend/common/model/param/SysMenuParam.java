package org.example.backend.common.model.param;

import lombok.Data;
import org.example.backend.common.model.BaseParam;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/12 17:32
 */
@Data
public class SysMenuParam extends BaseParam {

    @NotNull(message = "id不能为空，请检查id参数", groups = {delete.class, detail.class})
    private Integer id;

    @NotNull(message = "parentId不能为空，请检查parentId参数", groups = {edit.class, detail.class})
    private Integer parentId;

    private String path;

    @NotBlank(message = "名称不能为空，请检查name参数", groups = {add.class, edit.class})
    private String name;

    /**
     * 菜单类型（0目录 1菜单 2按钮）
     */
    @NotNull(message = "类型不能为空，请检查type参数", groups = {add.class, edit.class})
    @Min(value = 0, message = "菜单类型格式错误，请检查type参数", groups = {add.class, edit.class})
    @Max(value = 2, message = "菜单类型格式错误，请检查type参数", groups = {add.class, edit.class})
    private Integer type;

    private Integer typeIsNot;

    /**
     * 图标
     */
    private String icon;

    /**
     * 前端路由地址
     */
    private String router;

    @NotNull(message = "是否显示面包屑，请检查isBreadCrumb参数", groups = {add.class, edit.class})
    private Boolean isBreadCrumb;

    /**
     * 菜单权限URL
     */
    private String permissionPath;

    /**
     * 按钮权限标识
     */
    private String perms;

    @NotNull(message = "打开方式不能为空，请检查openType参数", groups = {add.class, edit.class})
    @Min(value = 1, message = "打开方式格式错误，请检查openType参数", groups = {add.class, edit.class})
    @Max(value = 3, message = "打开方式格式错误，请检查openType参数", groups = {add.class, edit.class})
    private Integer openType;

    /**
     * 链接地址
     */
    private String link;

    /**
     * 重定向地址
     */
    private String redirect;

    @NotNull(message = "是否可见不能为空，请检查visible参数", groups = {add.class, edit.class})
    private Boolean visible;

    @NotNull(message = "排序不能为空，请检查sort参数", groups = {add.class, edit.class})
    private Integer sort;

    private String remark;

    private Boolean isInit;

}
