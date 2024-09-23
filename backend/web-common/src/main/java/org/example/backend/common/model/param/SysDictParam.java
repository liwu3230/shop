package org.example.backend.common.model.param;

import lombok.Data;
import org.example.backend.common.model.BaseParam;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/12 17:32
 */
@Data
public class SysDictParam extends BaseParam {

    @NotNull(message = "id不能为空，请检查id参数", groups = {delete.class, detail.class})
    private Integer id;

    @NotBlank(message = "名称不能为空，请检查name参数", groups = {add.class, edit.class})
    private String name;

    @NotBlank(message = "编码不能为空，请检查code参数", groups = {add.class, edit.class})
    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = "只能为数字、字母、下划线的组合")
    private String code;

    @NotNull(message = "状态不能为空，请检查status参数", groups = {edit.class})
    @Min(value = 0, message = "状态格式错误，请检查status参数", groups = {edit.class})
    @Max(value = 2, message = "状态格式错误，请检查status参数", groups = {edit.class})
    private Integer status;

    @NotNull(message = "排序不能为空，请检查sort参数", groups = {add.class, edit.class})
    private Integer sort;

    private String remark;

    @Valid
    @NotNull(message = "字典值集合不能为空", groups = {add.class, edit.class})
    @Size(min = 1, message = "字典值集合至少要有一个值", groups = {add.class, edit.class})
    private List<SysDictData> dataList;

    @Data
    public static class SysDictData {

        @NotBlank(message = "字典值名称不能为空，请检查name参数", groups = {add.class, edit.class})
        private String name;

        @NotBlank(message = "字典值不能为空，请检查value参数", groups = {add.class, edit.class})
        private String value;

        @NotNull(message = "字典值排序不能为空，请检查sort参数", groups = {add.class, edit.class})
        private Integer sort;

    }

}
