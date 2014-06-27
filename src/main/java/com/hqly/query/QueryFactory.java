package com.hqly.query;

import com.hqly.presenter.PresenterFactory;

public class QueryFactory {

	public static Query get(String selectHql) {
		if(selectHql.matches("^from.*|^select.*")){
			return new SelectQuery(new PresenterFactory());
		}
		return new UpdateQuery(new PresenterFactory());
	}

}
