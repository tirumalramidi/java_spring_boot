package com.springBootAOP.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyApiAnlyticsAspect {


    @Before("com.springBootAOP.AOPDemo.aspect.AllAspectsPointcutExpressions.daoPackageNoGetterSetter()")
    public void ApiAnalytics(){
        System.out.println("****** Api Analytics");
    }



}
