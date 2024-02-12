package com.springBootAOP.AOPDemo;

import com.springBootAOP.AOPDemo.dao.AccountDAO;
import com.springBootAOP.AOPDemo.dao.MembershipDAO;
import com.springBootAOP.AOPDemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){

		return runner -> {

//			System.out.println("Hello world");
//			demoTheBeforeAdvice(accountDAO, membershipDAO);

//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
//			demoTheAroundAdvice(trafficFortuneService);

//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceReThrowException(trafficFortuneService);

		};

	}

	private void demoTheAroundAdviceReThrowException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n Main program: demo app for AroundAdviceReThrowException advice");
		System.out.println("Calling the method:- getFortune()");

		boolean tripWire = true;

		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\nReturned data:-"+ data);
		System.out.println("Finished");



	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n Main program: demo app for AroundAdviceHandleException advice");
		System.out.println("Calling the method:- getFortune()");

		boolean tripWire = true;

		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\nReturned data:-"+ data);
		System.out.println("Finished");


	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n Main program: demo app for around advice");

		String data = trafficFortuneService.getFortune();
		System.out.println("Returned data:-"+ data);
		System.out.println("Finished");

	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {


		List<Account> listAccounts = null;

		try {
//			boolean tripWire = true;
			boolean tripWire = false;

			listAccounts = accountDAO.findAccounts(tripWire);
		}catch (Exception exec){
			System.out.println("\n\n Main Program: --caught exception:- "+ exec);
		}

		System.out.println("\n\n Main method:-- demoTheAfterFinallyAdvice");
		System.out.println("--------");
		System.out.println(listAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {

		List<Account> listAccounts = null;

		try {
			boolean tripWire = true;

			listAccounts = accountDAO.findAccounts(tripWire);
		}catch (Exception exec){
			System.out.println("\n\n Main Program: --caught exception:- "+ exec);
		}

		System.out.println("\n\n Main method:-- demoTheAfterThrowingingAdvice");
		System.out.println("--------");
		System.out.println(listAccounts);
		System.out.println("\n");


	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		List<Account> listAccounts = accountDAO.findAccounts();

		System.out.println("\n\n Main method:-- demoTheAfterReturningAdvice");
		System.out.println("--------");
		System.out.println(listAccounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		accountDAO.addAccount(new Account(), true);
		System.out.println("______________");
		accountDAO.doWork();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		System.out.println("______________");

		membershipDAO.addSillyMember();
		System.out.println("______________");
		membershipDAO.goToSleep();





	}


}



