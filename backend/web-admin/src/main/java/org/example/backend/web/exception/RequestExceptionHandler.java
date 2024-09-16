package org.example.backend.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.R;
import org.example.backend.common.utils.T;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);

        R r = R.error("数据库中已存在该记录");
        r.put("trace", T.getExceptionDetail(e));
        return r;
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {

        if (e instanceof InterruptedException) {
            log.warn(e.getMessage(), e);
        } else {
            if (e.getMessage() != null && e.getMessage().equals("getOutputStream() has already been called for this response")) {
                log.warn(e.getMessage(), e);
            } else {
                log.error(e.getMessage(), e);
            }
        }
        String exDetail = T.getExceptionDetail(e);
        R r = R.error("系统异常：" + e.getMessage());
        r.put("trace", exDetail);
        return r;
    }

    @ExceptionHandler(Throwable.class)
    public R handleThrowable(Throwable e) {
        log.error(e.getMessage(), e);

        String exDetail = T.getExceptionDetail(e);
        R r = R.error("系统异常：" + e.getMessage());
        r.put("trace", exDetail);
        return r;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R handleMissingServletRequestParameterException(Exception e) {

        String exDetail = T.getExceptionDetail(e);
        R r = R.error(400, T.defaultValue(e.getMessage(), exDetail));
        r.put("trace", exDetail);
        return r;
    }

    @ExceptionHandler(BindException.class)
    public R handleBindException(BindException e) {
        StringBuilder errorMsg = new StringBuilder();
        e.getFieldErrors().forEach(x -> errorMsg.append(x.getField()).append(x.getDefaultMessage()).append(","));
        String exDetail = T.getExceptionDetail(e);
        R r = R.error(400, errorMsg.toString());
        r.put("trace", exDetail);
        return r;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder resultBuilder = new StringBuilder();
        BindingResult result = e.getBindingResult();
        List<ObjectError> errors = result.getAllErrors();
        if (errors != null && errors.size() > 0) {
            for (ObjectError error : errors) {
                if (error instanceof FieldError) {
                    FieldError fieldError = (FieldError) error;
                    String fieldName = fieldError.getField();
                    String fieldErrMsg = fieldError.getDefaultMessage();
                    resultBuilder.append(fieldName).append(" ").append(fieldErrMsg).append(";");
                }
            }
        }
        String exDetail = T.getExceptionDetail(e);
        R r = R.error(400, resultBuilder.toString());
        r.put("trace", exDetail);
        return r;
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public R handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error(e.getMessage(), e);
        String exDetail = T.getExceptionDetail(e);
        R r = R.error(400, "Maximum upload size exceeded");
        r.put("trace", exDetail);
        return r;
    }

}
