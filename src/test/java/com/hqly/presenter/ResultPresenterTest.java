package com.hqly.main;

import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import com.hqly.model.Country;

public class PresenterTest {

    @Test
    public void commandLinePresenterWithJustCountry(){
	Presenter presenter = new Presenter();
	List<Country> list = new ArrayList<Country>();
	Country country = new Country();
	country.setKey(1L);
	country.setCapital("Delhi");
	country.setCode("IN");
	country.setName("India");
	list.add(country);
	String output = presenter.format(list);
	MatcherAssert.assertThat(output, is(new PresenterMatcher()));
    }
}
