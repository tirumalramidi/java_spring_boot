package com.springBootAOP.AOPDemo.dao;

import com.springBootAOP.AOPDemo.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account ,boolean vipFlag) {

        System.out.println(getClass() + " doing my db work adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doWork() method");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " getName() method");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName() method");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode() method");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode() method");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {

//            List<Account> accountList = new ArrayList<>();
//            Account account1 = new Account("John1", "Silver1");
//            Account account2 = new Account("John2", "Silver2");
//            Account account3 = new Account("John3", "Silver3");
//            Account account4 = new Account("John4", "Silver4");
//            Account account5 = new Account("John5", "Silver5");
//            accountList.add(account1);
//            accountList.add(account2);
//            accountList.add(account3);
//            accountList.add(account4);
//            accountList.add(account5);
//            return accountList;

        return findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("findAccounts exception created");
        }

        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account("John1", "Silver1");
        Account account2 = new Account("John2", "Silver2");
        Account account3 = new Account("John3", "Silver3");
        Account account4 = new Account("John4", "Silver4");
        Account account5 = new Account("John5", "Silver5");
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        accountList.add(account4);
        accountList.add(account5);
        return accountList;
    }
}
