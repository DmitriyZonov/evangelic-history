package org.example.evangelhistory.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
@Slf4j
public class AdviceExecutor {
    @After("PointCutSearcher.getAllClients()")
    public void methodByNameAdvice(JoinPoint joinPoint) {
        log.info("Method: " + joinPoint.toShortString() + " is done his work");
    }
    @Before("PointCutSearcher.allControllers()")
    public void methodsByPackage(JoinPoint joinPoint) {
        log.info("Starting controller " + joinPoint.toShortString());
    }
}
