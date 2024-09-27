package org.example.backend.common.storage;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.IoUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.storage.config.FileModuleType;
import org.example.backend.common.storage.config.FileStorageProperties;
import org.example.backend.common.storage.config.PutObjectResult;
import org.example.backend.common.util.DateUtil;
import org.example.backend.common.util.Delimiters;
import org.example.backend.common.util.T;
import org.example.backend.common.util.VideoFrameExtractor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/22 12:45
 */
@Slf4j
@Component
public class LocalFileStorage extends AbstractStorage {

    @Resource
    FileStorageProperties fileStorageProperties;

    @Override
    public PutObjectResult upload(MultipartFile file, FileModuleType moduleType) throws Exception {
        PutObjectResult uploadResult = buildPutObjectResult(file);

        String fileType = FileTypeUtil.getType(file.getInputStream(), uploadResult.getOriginalFileName());
        List<String> imageMimeTypes = Arrays.asList("jpeg", "jpg", "png", "gif", "webp");
        List<String> videoMimeTypes = Arrays.asList("mp4", "flv", "m3u8");
        if (imageMimeTypes.contains(fileType)) {
            this.uploadImage(file, moduleType, uploadResult,
                    fileStorageProperties.getThumbnailSize(), fileStorageProperties.getThumbnailFormat());
        } else if (videoMimeTypes.contains(fileType)) {
            this.uploadVideo(file, moduleType, uploadResult);
        } else {
            String fullPath = this.saveFile(file.getInputStream(), moduleType, uploadResult.getObjectKey());
            uploadResult.setPath(fullPath);
        }

        uploadResult.setDownloadUrl(String.format("%s/file/download?id=%s", fileStorageProperties.getDomain(), uploadResult.getObjectKey()));
        return uploadResult;
    }

    @Override
    @SuppressWarnings("all")
    public void delete(SysAttachment attachment) throws Exception {
        if (T.isNotBlank(attachment.getAttDir())) {
            File file = new File(attachment.getAttDir());
            if (file.isFile()) {
                file.delete();
            }
        }
        if (T.isNotBlank(attachment.getSattDir())) {
            File file = new File(attachment.getSattDir());
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    @Override
    public int getType() {
        return 1;
    }

    private String saveFile(InputStream inputStream, FileModuleType moduleType, String objectKey) throws Exception {
        String directory = fileStorageProperties.getLocalDir() + moduleType.getLabel() + File.separator
                + DateUtil.format(new Date(), DateUtil.DATE);
        Path fullPath = Paths.get(directory + File.separator + objectKey);
        Path parentDir = fullPath.getParent();
        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }
        Files.copy(inputStream, fullPath, StandardCopyOption.REPLACE_EXISTING);
        return fullPath.toRealPath().toString();
    }

    private void uploadVideo(MultipartFile file, FileModuleType moduleType, PutObjectResult uploadResult) throws Exception {
        InputStream in = file.getInputStream();
        ByteArrayInputStream snapshotIn = null;
        ByteArrayInputStream fileIn = new ByteArrayInputStream(file.getBytes());
        try {
            VideoFrameExtractor.SnapshotImage snapshotImage = VideoFrameExtractor.extractFirstFrame(fileIn);
            snapshotIn = snapshotImage.getInputStream();
            String snapshotImageName = T.UUID() + Delimiters.DOT + snapshotImage.getImageFormat();
            try {
                String snapshotPath = this.saveFile(snapshotIn, FileModuleType.SNAPSHOT, snapshotImageName);
                uploadResult.setSnapshotPath(snapshotPath);
            } catch (Exception e) {
                log.error("上传视频封面图失败", e);
            }
            String path = this.saveFile(in, moduleType, uploadResult.getObjectKey());
            uploadResult.setPath(path);
        } catch (Exception e) {
            throw new RuntimeException("上传视频失败！", e);
        } finally {
            IoUtil.close(in);
            IoUtil.close(fileIn);
            IoUtil.close(snapshotIn);
        }
    }

    private void uploadImage(MultipartFile file, FileModuleType moduleType, PutObjectResult uploadResult,
                             Integer thumbnailSize, String thumbnailFormat) throws Exception {
        BufferedImage bufferImage = null;
        InputStream in = file.getInputStream();
        ByteArrayInputStream thumbnailStream = new ByteArrayInputStream(file.getBytes());
        try {
            bufferImage = Thumbnails.of(thumbnailStream).scale(1.00f).outputQuality(1.00f).asBufferedImage();
            if (bufferImage.getHeight(null) > thumbnailSize || bufferImage.getWidth(null) > thumbnailSize) {
                ByteArrayOutputStream out = null;
                ByteArrayInputStream snapshotIn = null;
                try {
                    out = new ByteArrayOutputStream();
                    thumbnailStream = new ByteArrayInputStream(file.getBytes());
                    Thumbnails.of(thumbnailStream).outputFormat(thumbnailFormat).imageType(BufferedImage.TYPE_INT_ARGB)
                            .size(thumbnailSize, thumbnailSize).toOutputStream(out);
                    snapshotIn = new ByteArrayInputStream(out.toByteArray());

                    String snapshotImageName = T.UUID() + Delimiters.DOT + thumbnailFormat;
                    String snapshotPath = this.saveFile(snapshotIn, FileModuleType.SNAPSHOT, snapshotImageName);
                    uploadResult.setSnapshotPath(snapshotPath);
                } catch (Exception e) {
                    log.error("上传略缩图失败", e);
                } finally {
                    IoUtil.close(out);
                    IoUtil.close(snapshotIn);
                }
            }
            String path = this.saveFile(in, moduleType, uploadResult.getObjectKey());
            uploadResult.setPath(path);
        } catch (Exception e) {
            throw new RuntimeException("上传图片失败！", e);
        } finally {
            IoUtil.close(in);
            IoUtil.close(thumbnailStream);
            try {
                if (bufferImage != null) {
                    bufferImage.getGraphics().dispose();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
