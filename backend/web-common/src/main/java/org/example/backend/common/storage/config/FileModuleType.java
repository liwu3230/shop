package org.example.backend.common.storage.config;

import lombok.Getter;

import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/6 18:48
 */
@Getter
public enum FileModuleType {

    COMMON(1, "common"),
    USER(2, "user"),
    SNAPSHOT(3, "snapshot"),
    OTHER(4, "other");

    private final int value;

    private final String label;

    FileModuleType(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public static FileModuleType getType(Integer value) {
        if (Objects.nonNull(value)) {
            for (FileModuleType type : FileModuleType.values()) {
                if (Objects.equals(type.value, value)) {
                    return type;
                }
            }
        }
        return null;
    }

}
