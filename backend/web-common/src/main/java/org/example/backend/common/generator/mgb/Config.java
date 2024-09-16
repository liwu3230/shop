package org.example.backend.common.generator.mgb;

import java.io.File;

public class Config {

    public static final String backendDir = System.getProperty("user.dir") + File.separator + "backend";
    public static final String frontendDir = System.getProperty("user.dir") + File.separator + "frontend";

    public static final String projectPath = "src" + File.separator + "main" + File.separator + "java" + File.separator;
    public static final String resourcesPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    public static final String bpmModuleName = "web-bpm";
    public static final String commonModuleName = "web-common";
    public static final String controllerModuleName = "web-controller";

    public static final String controllerPackage = "org.example.backend.web.controller.business";
    public static final String servicePackage = "org.example.backend.common.service.business";
    public static final String daoPackage = "org.example.backend.common.primary.base.dao";
    public static final String modelPackage = "org.example.backend.common.model";
    public static final String paramPackage = "org.example.backend.common.model.param.business";
    public static final String exportHeadPackage = "org.example.backend.common.excel.exporter.head";
    public static final String importHeadPackage = "org.example.backend.common.excel.importer.head";
    public static final String importListenerPackage = "org.example.backend.common.excel.importer.listener";

    public static final String commonModulePath = backendDir + File.separator + commonModuleName + File.separator;
    public static final String bpmModulePath = backendDir + File.separator + bpmModuleName + File.separator;
    public static final String controllerModulePath = backendDir + File.separator + controllerModuleName + File.separator;

    public static final String frontendPagesPath = frontendDir + File.separator + "src" + File.separator + "pages" + File.separator;


    /**
     * 模板文件
     */
    public static final String[] templates = {
            "vm" + File.separator + "Controller.java.vm",
            "vm" + File.separator + "Service.java.vm",
            "vm" + File.separator + "Param.java.vm",
            "vm" + File.separator + "Import.java.vm",
            "vm" + File.separator + "ImportListener.java.vm",
            "vm" + File.separator + "Export.java.vm",

            "vm" + File.separator + "config.tsx.vm",
            "vm" + File.separator + "index.tsx.vm",
    };

    /**
     * 获取文件生成路径
     */
    public static String getFilePath(String template, CodeGenParam codeGenParam) {
        String fileName = template.substring(template.indexOf(File.separator) + 1, template.lastIndexOf(".vm"));
        if (template.contains("Controller.java.vm")) {
            return controllerModulePath + projectPath + controllerPackage.replace(".", File.separator) + File.separator + codeGenParam.getClazzName() + fileName;
        }
        if (template.contains("Service.java.vm")) {
            return commonModulePath + projectPath + servicePackage.replace(".", File.separator) + File.separator + codeGenParam.getClazzName() + fileName;
        }
        if (template.contains("Param.java.vm")) {
            return commonModulePath + projectPath + paramPackage.replace(".", File.separator) + File.separator + codeGenParam.getClazzName() + fileName;
        }
        if (template.contains("Import.java.vm")) {
            return commonModulePath + projectPath + importHeadPackage.replace(".", File.separator) + File.separator + codeGenParam.getClazzName() + fileName;
        }
        if (template.contains("ImportListener.java.vm")) {
            return commonModulePath + projectPath + importListenerPackage.replace(".", File.separator) + File.separator + codeGenParam.getClazzName() + fileName;
        }
        if (template.contains("Export.java.vm")) {
            return commonModulePath + projectPath + exportHeadPackage.replace(".", File.separator) + File.separator + codeGenParam.getClazzName() + fileName;
        }

        //前端
        if (template.contains("config.tsx.vm")) {
            return frontendPagesPath + codeGenParam.getClazzName() + File.separator + fileName;
        }
        if (template.contains("index.tsx.vm")) {
            return frontendPagesPath + codeGenParam.getClazzName() + File.separator + fileName;
        }
        return null;
    }
}
