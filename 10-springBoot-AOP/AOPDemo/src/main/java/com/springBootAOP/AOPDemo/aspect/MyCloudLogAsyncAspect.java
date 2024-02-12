package com.springBootAOP.AOPDemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {

    @Before("com.springBootAOP.AOPDemo.aspect.AllAspectsPointcutExpressions.daoPackageNoGetterSetter()")
    public void LogToCloudAsync(){
        System.out.println("****** eLog to cloud async");
    }

}
