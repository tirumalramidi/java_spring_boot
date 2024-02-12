package com.springBootAOP.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addSillyMember() {

        System.out.println(getClass() + " doing my db work adding an Membership account");

    }

    @Override
    public void goToSleep() {

        System.out.println(getClass() + " doing my goint to sleep");

    }




}
