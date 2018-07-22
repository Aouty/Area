package com.aouty.area.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aouty
 * @date 2018-04-15 11:38
 * @description 统一的异常处理类
 */
@ControllerAdvice //@ControllerAdvice注解标识这个类GlobalExceptionHandler为异常处理类
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)//@ExceptionHandler表明要处理的异常类是Exception.class
    @ResponseBody //@ResponseBody：返回的是错误信息，不是错误页面
    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
        //javax.servlet.http.HttpServletRequest
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }

}
