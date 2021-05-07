package com.golaxy.aop;

import com.golaxy.exception.CustomException;
import com.golaxy.pojo.ReturnResult;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RequestWrappingAspect {

    @Pointcut("execution(* com.golaxy.controller.*.*(..))")
    public void anyControllerPointCut() {
    }


    @Around("anyControllerPointCut()")
    public Object WrapResponse(ProceedingJoinPoint joinPoint) {
        Gson gson = new Gson();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            String result;
            if(e instanceof CustomException) {
                CustomException customException = (CustomException) e;
                result = gson.toJson(new ReturnResult(customException.getErrorCode()));
            } else {
                result = gson.toJson(new ReturnResult("1", e.getMessage(), ""));
            }
            return result;
        }
    }
}
