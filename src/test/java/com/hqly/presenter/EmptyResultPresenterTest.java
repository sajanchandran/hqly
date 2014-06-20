package com.hqly.presenter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class EmptyResultPresenterTest {

	@Test
	public void formatEmptyResultCorrectlyForEmptyResultObject(){
		Presenter presenter = new EmptyResultPresenter();
		String output = presenter.format(new ArrayList<Object>());
		assertThat(output, is("No Records Found"));
	}
	
	@Test
	public void formatEmptyResultCorrectlyForNullResultObject(){
		Presenter presenter = new EmptyResultPresenter();
		String output = presenter.format(null);
		assertThat(output, is("No Records Found"));
	}
}
