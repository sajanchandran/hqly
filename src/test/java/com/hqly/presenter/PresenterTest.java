package com.hqly.presenter;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.hqly.model.Country;

public class PresenterTest {

	@Test
	public void convertObjectToString(){
		Country country = new Country();
		country.setKey(123L);
		country.setCapital("Delhi");
		country.setCode("IN");
		country.setName("India");
		Presenter presenter = new ResultPresenter();
		String toString = presenter.convertObjectToString(country);
		assertThat(toString, Is.is("Key=123,Name=India,Code=IN,Capital=Delhi"));
	}
}
