package org.example.backend.common.model.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/15 10:58
 */
@Getter
public enum MenuType {

    CATALOG(0, "目录"),
    MENU(1, "菜单"),
    BUTTON(2, "按钮");

    private final int value;
    private final String label;

    MenuType(int value, String label) {
        this.value = value;
        this.label = label;
    }

}
