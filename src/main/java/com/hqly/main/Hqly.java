package com.hqly.main;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hqly {

    public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/database.xml", "/spring/config.xml");
	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	QueryHelper helper = new QueryHelper();
	helper.setSession(sessionFactory.openSession());
	List<Object> output = helper.execute(args[0]);
	System.out.println(output);
	context.close();
    }
}
