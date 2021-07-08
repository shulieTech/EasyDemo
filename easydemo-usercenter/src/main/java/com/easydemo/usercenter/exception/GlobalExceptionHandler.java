package com.easydemo.usercenter.exception;

import com.easydemo.usercenter.resp.RtnResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author qianshui
 * @Date 2021/6/21 下午7:13
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BizUserException.class)
    @ResponseBody
    public RtnResp bizUserExceptionHandler(BizUserException e) {
        logger.error("业务异常-{}", e);
        return RtnResp.failure("【UserCenter】业务异常-" + e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RtnResp exceptionHandler(Exception e) {
        logger.error("系统异常-{}", e);
        return RtnResp.failure("【UserCenter】系统异常-" + e.getMessage());
    }
}
