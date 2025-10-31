package org.example.evangelhistory.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class PointCutSearcher {
    @Pointcut("execution(public * org..ClientService.getAllClients(*))")
    public void getAllClients(){}

    @Pointcut("within(org..*Controller)")
    public void allControllers(){}
}
