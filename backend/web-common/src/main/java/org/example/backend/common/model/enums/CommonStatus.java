package org.example.backend.common.model.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/15 10:58
 */
@Getter
public enum CommonStatus {

    ENABLE(0, "正常"),
    DISABLE(1, "停用"),
    DELETED(2, "删除");

    private final int value;
    private final String label;

    CommonStatus(int value, String label) {
        this.value = value;
        this.label = label;
    }

}
