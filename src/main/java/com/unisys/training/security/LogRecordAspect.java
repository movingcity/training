package com.unisys.training.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect   //定义一个切面
@Configuration
public class LogRecordAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

    // 定义切点Pointcut
    @Pointcut("execution(* com.unisys.training.controller.*.*(..))")
    public void excuteService() {
    }

    @Around("excuteService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}");

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();

        logger.info("请求结束，controller的返回值是 "+result);
        return result;
    }
}
