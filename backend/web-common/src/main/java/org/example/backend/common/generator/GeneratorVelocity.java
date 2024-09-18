package org.example.backend.common.generator;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.example.backend.common.generator.mgb.CodeGenParam;
import org.example.backend.common.generator.mgb.Config;
import org.example.backend.common.utils.T;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 10:46
 */
public class GeneratorVelocity {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>() {{
            put("systemAdmin", "用户地址");
        }};

        map.forEach((clazz, desc) -> {
            if (T.isBlank(clazz)) {
                return;
            }
            CodeGenParam codeGenParam = CodeGenParam.builder()
                    .modelPackage(Config.modelPackage)
                    .paramPackage(Config.paramPackage)
                    .controllerPackage(Config.controllerPackage)
                    .daoPackage(Config.daoPackage)
                    .servicePackage(Config.servicePackage)
                    .exportHeadPackage(Config.exportHeadPackage)
                    .importHeadPackage(Config.importHeadPackage)
                    .importListenerPackage(Config.importListenerPackage)
                    .className(clazz).clazzName(StringUtils.capitalize(clazz))
                    .desc(desc)
                    .build();
            codeGenLocal(codeGenParam);
        });
    }

    public static void codeGenLocal(CodeGenParam codeGenParam) {
        //初始化参数
        Properties properties = new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine = new VelocityEngine(properties);

        for (String template : Config.templates) {
            File file = new File(Config.getFilePath(template, codeGenParam));
            //不覆盖存在的文件
            if (file.exists()) {
                System.out.println(file.getAbsolutePath() + "该文件已经存在!!");
                continue;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                Writer writer = new FileWriter(file);
                velocityEngine.mergeTemplate(template, "UTF-8", setContextVal(codeGenParam), writer);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static VelocityContext setContextVal(CodeGenParam codeGenParam) {
        VelocityContext velocityContext = new VelocityContext();
        Class clazz = codeGenParam.getClass();
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            fields.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                velocityContext.put(f.getName(), f.get(codeGenParam));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return velocityContext;
    }
}
