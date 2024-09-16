package org.example.backend.web.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/29 16:57
 */
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@Slf4j
@Aspect
@Component
public class RequestLogAspect {

    public static final int WARN_ELAPSED = 1000;

    @Pointcut("execution(* org.example.backend..*.controller..*(..))")
    public void requestServer() {
    }

    @Around("requestServer()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        //执行方法
        Object result = joinPoint.proceed();
        try {
            //执行时长(毫秒)
            long timeCost = System.currentTimeMillis() - start;
            //打印日志
//            RequestInfo requestInfo = printLog(joinPoint, timeCost, result);
        } catch (Throwable e) {
            //这里只记录日志，保存日志失败不应该影响正常接口调用
            log.error("requestLogAspect handleLog error ", e);
        }
        return result;
    }

    @AfterThrowing(pointcut = "requestServer()", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, RuntimeException e) {
        try {
//            printErrorLog(joinPoint, e);
        } catch (Exception ex) {
            log.error("requestLogAspect handleErrorLog error ", e);
        }
    }

//    private RequestInfo printLog(ProceedingJoinPoint joinPoint, long timeCost, Object obj) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        RequestInfo requestInfo = new RequestInfo();
//        requestInfo.setIp(request.getRemoteAddr());
//        requestInfo.setRequestUrl(request.getRequestURL().toString());
//        requestInfo.setHttpMethod(request.getMethod());
//        requestInfo.setMethod(String.format("%s.%s", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName()));
//        requestInfo.setRequestParams(getRequestParams(request, joinPoint));
//        requestInfo.setCreateTime(new Date());
//        requestInfo.setResult(obj);
//        requestInfo.setTimeCost(timeCost);
//        if (timeCost > WARN_ELAPSED) {
//            log.warn("Warn Request Info: {}", requestInfo.toString());
//        } else {
//            log.debug("Request Info: {}", requestInfo.toString());
//        }
//        return requestInfo;
//    }

//    private void printErrorLog(JoinPoint joinPoint, RuntimeException e) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        RequestInfo requestInfo = new RequestInfo();
//        requestInfo.setIp(IpUtils.getIpAddr(request));
//        requestInfo.setRequestUrl(request.getRequestURL().toString());
//        requestInfo.setHttpMethod(request.getMethod());
//        requestInfo.setMethod(String.format("%s.%s", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName()));
//        requestInfo.setRequestParams(getRequestParams(request, joinPoint));
//        requestInfo.setCreateTime(new Date());
//        requestInfo.setError(true);
//        requestInfo.setCauseMessage(e.getMessage());
//        log.error("Error Request Info: {}", JSON.toJSONString(requestInfo));//全局异常处理器已打印异常堆栈,这里就不重复打印了
//    }

    private String getRequestParams(HttpServletRequest request, JoinPoint joinPoint) {
        String httpMethod = request.getMethod();
        StringBuilder params = new StringBuilder();
        if ("POST".equals(httpMethod) || "PUT".equals(httpMethod) || "PATCH".equals(httpMethod)) {
            Object[] paramsArray = joinPoint.getArgs();
            // java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
            Object[] arguments = new Object[paramsArray.length];
            for (int i = 0; i < paramsArray.length; i++) {
                if (paramsArray[i] instanceof BindingResult || paramsArray[i] instanceof ServletRequest || paramsArray[i] instanceof ServletResponse || paramsArray[i] instanceof MultipartFile) {
                    //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                    //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                    continue;
                }
                arguments[i] = paramsArray[i];
            }
            //日志数据太长的直接过滤掉
//            PropertyFilter proFilter = (o, name, value) -> {
//                if (value != null && value.toString().length() > 500) {
//                    return false;
//                }
//                return true;
//            };
            params = new StringBuilder(JSONObject.toJSONString(arguments));
        } else {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            // 请求的方法参数值
            Object[] args = joinPoint.getArgs();
            // 请求的方法参数名称
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paramNames = u.getParameterNames(method);
            if (args != null && paramNames != null) {
                for (int i = 0; i < args.length; i++) {
                    params.append("  ").append(paramNames[i]).append(": ").append(args[i]);
                }
            }
        }
        return params.toString();
    }

}
