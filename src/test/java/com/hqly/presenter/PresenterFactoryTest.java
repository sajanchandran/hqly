package com.hqly.presenter;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hqly.model.Country;

public class PresenterFactoryTest {

	private PresenterFactory factory = new PresenterFactory();
	
	@Test
	public void returnsCorrectPresenterForEmptyResultSet(){
		Presenter presenter = factory.getPresenter(new ArrayList<Object>());
		assertThat(presenter, instanceOf(EmptyResultPresenter.class));
	}
	
	@Test
	public void returnsCorrectPresenterForNotEmptyResultSet(){
		List<Object> list = new ArrayList<Object>();
		list.add(new Country());
		Presenter presenter = factory.getPresenter(list);
		assertThat(presenter, instanceOf(ResultPresenter.class));
	}
	
	@Test
	public void returnsCorrectPresenterWhenUserRequestIndividualTuples(){
		List<Object[]> resultList = new ArrayList<Object[]>();
		Object[] tuple1Array = new Object[2];
		tuple1Array[0] = 2L;
		tuple1Array[1] = "India";
		resultList.add(tuple1Array);
		Presenter presenter = factory.getPresenter(resultList);
		assertThat(presenter, instanceOf(TupleResultPresenter.class));
	}
	
	@Test
	public void returnsCorrectPresenterWhenUserRequestIndividualTuplesWithOneColumn(){
		List<Object> resultList = new ArrayList<Object>();
		resultList.add("India");
		resultList.add("UK");
		Presenter presenter = factory.getPresenter(resultList);
		assertThat(presenter, instanceOf(ResultPresenter.class));
	}
	
	@Test
	public void returnsCorrectPresenterForDMLQueries(){
		Presenter presenter = factory.getPresenter(2);
		assertThat(presenter, instanceOf(UpdateResultPresenter.class));
	}
}
