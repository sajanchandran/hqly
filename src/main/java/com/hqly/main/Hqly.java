package com.hqly.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hqly {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/spring/database.xml", "/spring/config.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");
		QueryHelper helper = new QueryHelper();
		helper.setSession(sessionFactory.openSession());
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>>");
		while(scanner.hasNextLine()){
			List<Object> output = helper.execute(scanner.nextLine());
			System.out.println(new Presenter().format(output));
		}
		System.out.println(">>>");
	}
}
