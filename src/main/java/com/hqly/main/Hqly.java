package com.hqly.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hqly.presenter.Presenter;
import com.hqly.presenter.PresenterFactory;
import com.hqly.query.QueryHelper;

public class Hqly {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/database.xml", "/spring/config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		QueryHelper helper = new QueryHelper();
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>>");
		PresenterFactory factory = new PresenterFactory();
		while(scanner.hasNextLine()){
			Session session = sessionFactory.openSession();
			helper.setSession(session);
			String sql = scanner.nextLine();
			List<Object> output = helper.select(sql);
			Presenter presenter = factory.getPresenter(output);
			System.out.println(presenter.format(output));
			System.out.println(">>>");
			session.close();
		}
		scanner.close();
		context.close();
	}
}
