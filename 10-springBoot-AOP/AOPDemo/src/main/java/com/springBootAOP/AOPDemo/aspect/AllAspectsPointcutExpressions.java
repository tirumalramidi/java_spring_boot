package com.springBootAOP.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AllAspectsPointcutExpressions {


    @Pointcut("execution(* com.springBootAOP.AOPDemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.springBootAOP.AOPDemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.springBootAOP.AOPDemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter(){};



}
