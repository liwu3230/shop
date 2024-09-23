package org.example.backend.common.storage;

import com.alibaba.fastjson2.JSONObject;
import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.Protocol;
import com.aliyun.oss.model.PutObjectRequest;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.storage.config.FileModuleType;
import org.example.backend.common.storage.config.FileStorageProperties;
import org.example.backend.common.storage.config.PutObjectResult;
import org.example.backend.common.storage.config.StorageConf;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/22 12:45
 */
@Slf4j
@Component
@ConditionalOnProperty(name = "storage.platform", havingValue = "oss")
public class OssFileStorage extends AbstractStorage {

    @Resource
    FileStorageProperties fileStorageProperties;

    @Override
    public PutObjectResult upload(MultipartFile file, FileModuleType moduleType) throws Exception {
        StorageConf config = fileStorageProperties.getOss();

        PutObjectResult uploadResult = buildPutObjectResult(file);
        String objectKey = uploadResult.getObjectKey();

        OSS ossClient = getOssClient(config.getAccessKey(), config.getSecretKey(), config.getEndpoint());
        try {
            if (!ossClient.doesBucketExist(config.getBucketName())) {
                ossClient.createBucket(config.getBucketName());
            }
            PutObjectRequest putObjectRequest = new PutObjectRequest(config.getBucketName(), objectKey, file.getInputStream());
            putObjectRequest.setProcess("true");
            com.aliyun.oss.model.PutObjectResult result = ossClient.putObject(putObjectRequest);
            int code = result.getResponse().getStatusCode();
            if (code != 200) {
                throw new RuntimeException(String.format("oss putObject resp fail, %s", JSONObject.toJSONString(result)));
            }

            uploadResult.setDownloadUrl(String.format("%s/%s/%s", config.getEndpoint(), config.getBucketName(), objectKey));
            return uploadResult;
        } catch (Exception e) {
            throw new RuntimeException(String.format("上传文件[%s]失败", objectKey), e);
        } finally {
            shutdown(ossClient);
        }
    }

    @Override
    public void delete(SysAttachment attachment) throws Exception {
        StorageConf config = fileStorageProperties.getOss();

        OSS ossClient = getOssClient(config.getAccessKey(), config.getSecretKey(), config.getEndpoint());
        try {
            if (!ossClient.doesBucketExist(config.getBucketName())) {
                return;
            }
            ossClient.deleteObject(config.getBucketName(), attachment.getName());
        } catch (Exception e) {
            throw new RuntimeException(String.format("删除文件[%s]失败", attachment.getName()), e);
        } finally {
            shutdown(ossClient);
        }
    }

    @Override
    public int getType() {
        return 2;
    }

    private OSS getOssClient(String accessKey, String secretKey, String endpoint) {
        ClientBuilderConfiguration clientBuilderConfig = new ClientBuilderConfiguration();
        clientBuilderConfig.setProtocol(Protocol.HTTPS);
        return new OSSClientBuilder().build(endpoint, accessKey, secretKey, clientBuilderConfig);
    }

    private void shutdown(OSS oss) {
        if (oss != null) {
            oss.shutdown();
        }
    }

}
