package org.example.backend.common.service;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.constants.Constants;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/17 20:59
 */
@Service
@Slf4j
public class SystemAttachmentService {

    @Resource
    SystemConfigService systemConfigService;

    /**
     * 给图片加前缀
     */
    public String prefixImage(String path) {
        // 如果那些域名不需要加，则跳过
        return path.replace(Constants.UPLOAD_TYPE_IMAGE + "/",
                getCdnUrl() + "/" + Constants.UPLOAD_TYPE_IMAGE + "/");
    }

    /**
     * 获取cdn url
     *
     * @return String
     */
    private String getCdnUrl() {
//        return asyncService.getCurrentBaseUrl();
//        1=>本地存储
//        2=>七牛云存储
//        3=>阿里云OSS
//        4=>腾讯COS
        String uploadType = systemConfigService.getValueByKeyException("upload_type");
        //获取配置信息
        int type = Integer.parseInt(uploadType);
        String url = "";
        switch (type) {
            case 1:
                url = systemConfigService.getValueByKey("site_url");
                break;
            default:
                break;
        }
        return url;
    }
}
