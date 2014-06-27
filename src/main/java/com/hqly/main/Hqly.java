package com.hqly.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hqly.query.Query;
import com.hqly.query.QueryFactory;

public class Hqly {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/database.xml", "/spring/config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>>");
		while(scanner.hasNextLine()){
			Session session = sessionFactory.openSession();
			String sql = scanner.nextLine();
			Query query = QueryFactory.get(sql);
			System.out.println(query.execute(session, sql));
			System.out.println(">>>");
			session.close();
		}
		scanner.close();
		context.close();
	}
}
