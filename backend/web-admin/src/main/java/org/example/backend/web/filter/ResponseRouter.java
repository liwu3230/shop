package org.example.backend.web.filter;

import org.example.backend.common.constants.Constants;
import org.example.backend.common.service.SystemAttachmentService;
import org.example.backend.common.utils.SpringBeanUtil;

/**
 * response路径处理
 */
public class ResponseRouter {

    public String filter(String data, String path) {
        boolean result = un().contains(path);
        if (result) {
            return data;
        }

        //根据需要处理返回值
        if (data.contains(Constants.UPLOAD_TYPE_IMAGE+"/") && !data.contains("data:image/png;base64")) {
            data = SpringBeanUtil.getBean(SystemAttachmentService.class).prefixImage(data);
        }

        return data;
    }

    public static String un() {
        return "";
    }
}
