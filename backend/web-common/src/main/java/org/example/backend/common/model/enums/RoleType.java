package org.example.backend.common.model.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * @Description: 角色类型
 * @Author: liwu3
 * @Date: 2021/7/26 18:24
 */
@Getter
public enum RoleType {

    NORMAL(0, "普通角色"),
    DEFAULT(1, "默认角色"),
    SUPER(2, "超级管理员");

    private final int value;

    private final String label;

    RoleType(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public static RoleType getType(Integer value) {
        if (Objects.nonNull(value)) {
            for (RoleType type : RoleType.values()) {
                if (type.value == value) {
                    return type;
                }
            }
        }
        return null;
    }

}
