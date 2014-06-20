package com.hqly.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hqly.presenter.Presenter;
import com.hqly.presenter.PresenterFactory;

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
		PresenterFactory factory = new PresenterFactory();
		while(scanner.hasNextLine()){
			String sql = scanner.nextLine();
			List<Object> output = helper.execute(sql);
			Presenter presenter = factory.getPresenter(sql);
			System.out.println(presenter.format(output));
			System.out.println(">>>");
		}
		scanner.close();
		context.close();
	}
}
