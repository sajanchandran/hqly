package com.hqly.presenter;

import java.util.List;

public class UpdateResultPresenter extends Presenter{

	@Override
	public String format(List<?> list) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String format(int rowsUpdated) {
		return "No of records updated is "+rowsUpdated;
	}

}
