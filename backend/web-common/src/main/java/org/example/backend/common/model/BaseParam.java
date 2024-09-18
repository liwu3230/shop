package org.example.backend.common.model;

import lombok.Data;
import org.example.backend.common.aspect.DateTime;

import jakarta.validation.constraints.Min;
import java.io.Serializable;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/29 10:12
 */
@Data
public class BaseParam implements Serializable {

    @DateTime(message = "格式错误，正确格式为：yyyy-MM-dd HH:mm:ss")
    private String startTime;

    @DateTime(message = "格式错误，正确格式为：yyyy-MM-dd HH:mm:ss")
    private String endTime;

    @Min(value = 1, groups = {list.class})
    private int page = 1;

    @Min(value = 1, groups = {list.class})
    private int limit = 10;

    public int getOffset() {
        if (limit < 1 || page < 1) {
            return 0;
        } else {
            return limit * (page - 1);
        }
    }

    /**
     * 参数校验分组：列表
     */
    public @interface list {
    }

    /**
     * 参数校验分组：增加
     */
    public @interface add {
    }

    /**
     * 参数校验分组：编辑
     */
    public @interface edit {
    }

    /**
     * 参数校验分组：删除
     */
    public @interface delete {
    }

    /**
     * 参数校验分组：详情
     */
    public @interface detail {
    }

    /**
     * 参数校验分组：批量编辑
     */
    public @interface batchEdit {
    }

    /**
     * 参数校验分组：批量删除
     */
    public @interface batchDelete {
    }


}
