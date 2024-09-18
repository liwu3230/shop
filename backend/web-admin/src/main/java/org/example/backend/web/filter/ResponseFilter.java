package org.example.backend.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.utils.RequestUtil;
import org.example.backend.common.utils.T;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 返回值输出过滤器
 */
@Slf4j
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        //转换成代理类
        ResponseWrapper wrapperResponse = new ResponseWrapper((HttpServletResponse) response);
        // 这里只拦截返回，直接让请求过去，如果在请求前有处理，可以在这里处理
        filterChain.doFilter(request, wrapperResponse);
        //获取返回值
        byte[] content = wrapperResponse.getContent();
        //判断是否有值
        if (content.length > 0) {
            String str = new String(content, StandardCharsets.UTF_8);
            try {
                HttpServletRequest req = (HttpServletRequest) request;
                str = new ResponseRouter().filter(str, RequestUtil.getUri(req));
            } catch (Exception e) {
                log.error("response filter error", e);
            }
            ServletOutputStream outputStream = response.getOutputStream();
            if (T.isNotEmpty(str)) {
                outputStream.write(str.getBytes());
                outputStream.flush();
                outputStream.close();
                response.flushBuffer();
            }
        }
    }
}
