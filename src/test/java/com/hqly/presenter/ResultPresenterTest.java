package com.hqly.presenter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hqly.model.Country;

public class ResultPresenterTest {

    @Test
    public void withOneObjectToPresent(){
		Presenter presenter = new ResultPresenter();
		List<Country> list = new ArrayList<Country>();
		Country country = new Country();
		country.setKey(1L);
		country.setCapital("Delhi");
		country.setCode("IN");
		country.setName("India");
		list.add(country);
		String output = presenter.format(list);
		assertThat(output, is("Key=1,Name=India,Code=IN,Capital=Delhi" + System.lineSeparator()));
    }
    
    @Test
    public void withMoreObjectToPresent(){
    	Presenter presenter = new ResultPresenter();
    	List<Country> list = new ArrayList<Country>();
    	Country country = new Country();
    	country.setKey(1L);
    	country.setCapital("Delhi");
    	country.setCode("IN");
    	country.setName("India");
    	Country uk = new Country();
    	uk.setKey(2L);
    	uk.setCapital("London");
    	uk.setCode("UK");
    	uk.setName("Britai");
    	list.add(country);
    	list.add(uk);
    	String output = presenter.format(list);
    	System.out.println(output);
    	assertThat(output, is("Key=1,Name=India,Code=IN,Capital=Delhi" + System.lineSeparator() 
    			+"Key=2,Name=Britai,Code=UK,Capital=London" + System.lineSeparator() ));
    }
}
