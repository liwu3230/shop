package org.example.backend.common.generator.mgb;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/4 20:17
 */
@Data
@Builder
public class CodeGenParam {

    private String desc;

    /**
     * 类名 （小写）
     */
    private String className;

    /**
     * 类名 （首字母大写）
     */
    private String clazzName;

    /**
     * 生成Java模型包名
     */
    private String modelPackage;

    /**
     * 生成param模型包名
     */
    private String paramPackage;

    /**
     * controller包名
     */
    private String controllerPackage;

    /**
     * dao包名
     */
    private String daoPackage;

    /**
     * service包名
     */
    private String servicePackage;

    private String exportHeadPackage;
    private String importHeadPackage;
    private String importListenerPackage;

}
