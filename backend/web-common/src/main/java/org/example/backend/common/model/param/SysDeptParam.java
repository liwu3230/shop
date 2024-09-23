package org.example.backend.common.model.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.backend.common.model.BaseParam;


/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/12 17:32
 */
@Data
public class SysDeptParam extends BaseParam {

    @NotNull(message = "id不能为空，请检查id参数", groups = {delete.class, detail.class})
    private Integer id;

    @NotNull(message = "parentId不能为空，请检查parentId参数", groups = {edit.class, detail.class})
    private Integer parentId;

    private String path;

    @NotBlank(message = "名称不能为空，请检查name参数", groups = {add.class, edit.class})
    private String name;

    @NotNull(message = "排序不能为空，请检查sort参数", groups = {add.class, edit.class})
    private Integer sort;

    private String remark;

}
