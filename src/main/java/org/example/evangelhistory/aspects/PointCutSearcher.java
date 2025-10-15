package org.example.evangelhistory.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class PointCutSearcher {
    @Pointcut("execution(public * com..ClientService.getAllClients(*))")
    public void getAllClients(){}

    @Pointcut("within(com..*Controller)")
    public void allControllers(){}
}
