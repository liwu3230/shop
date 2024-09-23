package org.example.backend.common.model.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/11/22 15:36
 */
@Getter
public enum MenuOpenType {

    DEFAULT(1, "默认"),
    CUR_LINK(2, "当前页链接"),
    NEW_LINK(3, "新窗口链接"),
    ;

    private final int value;
    private final String label;

    MenuOpenType(int value, String label) {
        this.value = value;
        this.label = label;
    }

}
