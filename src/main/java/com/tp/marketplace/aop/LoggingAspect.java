package com.tp.marketplace.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Log before any method in the crop service
    @Before("execution(* com.tp.cropproject.service.CropService.*(..))")
    public void logBeforeCropServiceMethod() {
        logger.info("A method is about to execute in the CropService");
    }

    // Log after any method in the crop service
    @After("execution(* com.tp.cropproject.service.CropService.*(..))")
    public void logAfterCropServiceMethod() {
        logger.info("A method has executed in the CropService");
    }

    // Log before any method in the marketplace service
    @Before("execution(* com.tp.cropproject.service.MarketplaceService.*(..))")
    public void logBeforeMarketplaceServiceMethod() {
        logger.info("A method is about to execute in the MarketplaceService");
    }

    // Log after any method in the marketplace service
    @After("execution(* com.tp.cropproject.service.MarketplaceService.*(..))")
    public void logAfterMarketplaceServiceMethod() {
        logger.info("A method has executed in the MarketplaceService");
    }

    // Around advice to log before and after method execution in both services
    @Around("execution(* com.tp.cropproject.service.*.*(..))")
    public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before executing method: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // Continue to method execution
        logger.info("After executing method: " + joinPoint.getSignature().getName());
        return result;
    }
}
