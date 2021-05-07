package com.golaxy.aop;

import com.golaxy.pojo.ReturnResult;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Autowired
    private Gson gson;

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
        logger.error(e.getMessage());
        return gson.toJson(new ReturnResult("1", e.getMessage(), ""));
    }
}
