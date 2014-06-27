package com.hqly.query;

import org.hibernate.Session;

import com.hqly.presenter.Presenter;
import com.hqly.presenter.PresenterFactory;

public class UpdateQuery implements Query {

	private PresenterFactory presenterFactory;

	public UpdateQuery(PresenterFactory presenterFactory) {
		this.presenterFactory = presenterFactory;
	}

	@Override
	public String execute(Session session, String hql) {
		int updateCount = session.createQuery(hql).executeUpdate();
		Presenter presenter = presenterFactory.getPresenter(updateCount);
		return presenter.format(updateCount);
	}

}
