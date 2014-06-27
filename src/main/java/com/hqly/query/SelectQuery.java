package com.hqly.query;

import java.util.List;

import org.hibernate.Session;

import com.hqly.presenter.Presenter;
import com.hqly.presenter.PresenterFactory;

public class SelectQuery implements Query {

	private PresenterFactory presenterFactory;

	public SelectQuery(PresenterFactory presenterFactory) {
		this.presenterFactory = presenterFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute(Session session, String hql) {
		List<Object> list = session.createQuery(hql).list();
		Presenter presenter = this.presenterFactory.getPresenter(list);
		return presenter.format(list);
	}

}
