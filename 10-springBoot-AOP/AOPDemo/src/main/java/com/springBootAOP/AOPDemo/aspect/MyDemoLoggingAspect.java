package com.springBootAOP.AOPDemo.aspect;

import com.springBootAOP.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

//    @Before("execution(* com.springBootAOP.AOPDemo.dao.*.*(..))")
//    public void beforeAddAccountAdvice(){
//
//        System.out.println("\n ****** Executing @Before advice on method addAccount()");
//
//    }


//    @Before("forDaoPackage()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("****** Executing @Before advice on method addAccount()");
//
//    }

//    @Before("forDaoPackage()")
//    public void apiAnalytics(){
//        System.out.println("****** Doing some api analytics");
//    }

    @Before("com.springBootAOP.AOPDemo.aspect.AllAspectsPointcutExpressions.daoPackageNoGetterSetter()")
    public void BeforeAdvice(JoinPoint joinPoint){

        System.out.println("****** Before Advice");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("The current method signature is: "+methodSignature);

        Object args[] = joinPoint.getArgs();

        System.out.println("method args are displayed here, if there are any");
        for(Object arg : args){
            System.out.println("--------------///////"+arg);

            if(arg instanceof Account){

                Account account = (Account) arg;

                System.out.println("***** Account Name:- "+ account.getName());
                System.out.println("***** Account Name:- "+ account.getLevel());

            }
        }
        System.out.println("End current aspect");


    }


    @AfterReturning(pointcut = "execution(* com.springBootAOP.AOPDemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toString();
        System.out.println("\n-------------------Executing AfterReturning advice:- "+ method);
        System.out.println("\n-------------------Before modification result is:- "+ result);

        convertAccountNamesToUpperCase(result);
        System.out.println("\n-------------------Modified result is:- "+ result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account account : result){

            String theUpperName = account.getName().toUpperCase();
            account.setName(theUpperName);

        }

    }

    @AfterThrowing(pointcut = "execution(* com.springBootAOP.AOPDemo.dao.AccountDAO.findAccounts(..))",
            throwing = "excep")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable excep){

        String method = joinPoint.getSignature().toString();
        System.out.println("\n-------------------Executing AfterThrowing advice:- "+ method);
        System.out.println("\n-------------------Exception is:- "+ excep);
    }

    @After("execution(* com.springBootAOP.AOPDemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toString();
        System.out.println("\n-------------------Executing After/(Finally) advice:- "+ method);
    }

    @Around("execution(* com.springBootAOP.AOPDemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toString();
        System.out.println("\n-------------------Executing @Around advice:- "+ method);

        long being = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
//            result = "Major accident but exception has been handled by the around advice aop";
            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - being;
        System.out.println("Duration:- " + duration/1000+ "seconds");

        return result;

    }

}
