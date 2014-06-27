package com.hqly.presenter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UpdateResultPresenterTest {

	@Test
	public void format(){
		UpdateResultPresenter presenter = new UpdateResultPresenter();
		String output = presenter.format(1);
		assertThat(output, is("No of records updated is 1"));
	}
}
