package org.example.backend.web.controller.sys;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.druid.util.StringUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.example.backend.common.model.R;
import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.service.FileStorageService;
import org.example.backend.common.storage.config.FileModuleType;
import org.example.backend.common.storage.config.PutObjectResult;
import org.example.backend.common.util.CommaSplitUtils;
import org.example.backend.common.util.Delimiters;
import org.example.backend.common.util.T;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/6 16:47
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileStorageController {

    @Resource
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public R uploadFile(HttpServletRequest request, @RequestParam(required = false) Integer module,
                        @RequestParam(required = false, defaultValue = "0") Integer pid) throws Exception {
        Map<String, MultipartFile> multiValueMap = ((MultipartHttpServletRequest) request).getFileMap();
        List<MultipartFile> files = new ArrayList<>(multiValueMap.values());
        if (T.isEmpty(files)) {
            return R.data("上传失败，请选择文件");
        }
        FileModuleType moduleType = FileModuleType.getType(module);
        if (moduleType == null) {
            moduleType = FileModuleType.COMMON;
        }

        Map<String, Object> result = new HashMap<>();
        List<PutObjectResult> objectResults = new ArrayList<>();
        for (MultipartFile file : files) {

            PutObjectResult objectResult = fileStorageService.upload(file, moduleType, pid);
            objectResults.add(objectResult);
        }
        result.put("value", objectResults.stream().map(PutObjectResult::getDownloadUrl).collect(Collectors.joining(",")));
        result.put("results", objectResults);
        return R.data(result);
    }

    @RequestMapping("delete")
    public R delete(@RequestParam Long attId) throws Exception {
        fileStorageService.delete(attId);
        return R.ok();
    }

    @RequestMapping("download")
    public void download(@RequestParam String id,
                         @RequestParam(required = false, defaultValue = "0") Integer mode,
                         @RequestParam(required = false) String style,
                         HttpServletResponse response) throws Exception {
        SysAttachment attachment = fileStorageService.getAttachmentByKey(id);
        if (attachment == null) {
            log.error("Attachment[" + id + "] is not exists!");
            response.setStatus(404);
            return;
        }

        String fileName = attachment.getRealName();
        String filePath = attachment.getAttDir();
        if (mode == 1 && T.isNotBlank(attachment.getSattDir())) {
            filePath = attachment.getSattDir();
            Path path = Paths.get(filePath);
            fileName = path.getFileName().toString();
        }
        File file = new File(filePath);
        if (!file.exists()) {
            log.error(file.getPath() + " is not exists!");
            response.setStatus(404);
            return;
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        long contentLength = file.length();
        if (attachment.getAttSize() > 0 && mode != 1) {
            contentLength = attachment.getAttSize();
        }
        response.setHeader("Content-Length", String.valueOf(contentLength));
        response.setCharacterEncoding("utf-8");
        byte[] buffer = new byte[2 * 1024];
        try (
                OutputStream outputStream = response.getOutputStream();
                InputStream inputStream = Files.newInputStream(file.toPath());
        ) {
            if (T.isNotBlank(style) && mode != 1) {
                outputThumbnail(style, inputStream, outputStream);
            } else {
                int len;
                while ((len = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                    outputStream.flush();
                }
                outputStream.flush();
            }
        } catch (Exception e) {
            log.error("download file error", e);
        }
    }

    private static void outputThumbnail(String style, InputStream inputStream, OutputStream outputStream) throws IOException {
        Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(inputStream);
        builder.imageType(BufferedImage.TYPE_INT_ARGB);
        builder.outputFormat("jpg");
        List<String> styles = CommaSplitUtils.toList(style);
        boolean useDefSize = true;
        for (String str : styles) {
            String[] arr = str.split(Delimiters.UNDER_LINE);
            if (arr.length == 2) {
                String key = arr[0];
                String val = arr[1];
                if (StringUtils.equalsIgnoreCase(key, "w") && NumberUtil.isInteger(val)) {
                    builder.width(Integer.parseInt(val));
                    useDefSize = false;
                }
                if (StringUtils.equalsIgnoreCase(key, "h") && NumberUtil.isInteger(val)) {
                    builder.height(Integer.parseInt(val));
                    useDefSize = false;
                }
                if (StringUtils.equalsIgnoreCase(key, "s") && NumberUtil.isNumber(val)) {
                    builder.scale(Double.parseDouble(val));
                    useDefSize = false;
                }
                if (StringUtils.equalsIgnoreCase(key, "q") && NumberUtil.isNumber(val)) {
                    builder.outputQuality(Double.parseDouble(val));
                    useDefSize = false;
                }
            }
        }
        if (useDefSize) {
            builder.size(200, 200);
        }
        builder.toOutputStream(outputStream);
    }

}
