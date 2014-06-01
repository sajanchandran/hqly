package com.hqly.main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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
	Assert.assertEquals("Key:1, Name:India, Code:IN, Capital:Delhi", output);
    }
}
