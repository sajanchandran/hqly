package com.hqly.presenter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hqly.model.Country;

public class TupleResultPresenterTest {

	private Presenter presenter = new TupleResultPresenter();
	
	@Test
	public void formatTupleResultCorrectlyForOneRecordWithMoreColumns(){
		List<Object[]> tupleList = populateResultListWithOneRecord();
		String output = presenter.format(tupleList);
		assertThat(output, is("2, India" +System.lineSeparator()));
	}
	
	@Test
	public void formatTupleResultCorrectlyForMoreRecordWithMoreColumns(){
		List<Object[]> tupleList = populateResultListWithMoreRecord();
		String output = presenter.format(tupleList);
		assertThat(output, is("2, India"+System.lineSeparator()+"3, Britain"+System.lineSeparator()));
	}
	
	@Test
	public void formatTupleResultCorrectlyForOneRecordWithOneColumn(){
		List<Object[]> tupleList = populateResultListWithOneRecordAndOneColumn();
		String output = presenter.format(tupleList);
		assertThat(output, is("2" +System.lineSeparator()));
	}
	
	@Test
	public void resultHasObjects(){
		List<Object[]> tupleList = populateResultListWithTwoRecordOfCountry();
		String output = presenter.format(tupleList);
		assertThat(output, is("Key=123,Name=India,Code=IN,Capital=Delhi" +
				System.lineSeparator() + "Key=234,Name=Britain,Code=UK,Capital=London" + System.lineSeparator()));
	}
	
	private List<Object[]> populateResultListWithTwoRecordOfCountry() {
		List<Object[]> tupleList = new ArrayList<Object[]>();
		Object[] tuple1Array = new Object[2];
		Country country = new Country();
		country.setKey(123L);
		country.setCapital("Delhi");
		country.setCode("IN");
		country.setName("India");
		tuple1Array[0] = country;
		Country ukCountry = new Country();
		ukCountry.setKey(234L);
		ukCountry.setCapital("London");
		ukCountry.setCode("UK");
		ukCountry.setName("Britain");
		tuple1Array[1] = ukCountry;
		tupleList.add(tuple1Array);
		return tupleList;
	}

	private List<Object[]> populateResultListWithOneRecordAndOneColumn() {
		List<Object[]> tupleList = new ArrayList<Object[]>();
		Object[] tuple1Array = new Object[1];
		tuple1Array[0] = 2L;
		tupleList.add(tuple1Array);
		return tupleList;
	}

	private List<Object[]> populateResultListWithOneRecord() {
		List<Object[]> tupleList = new ArrayList<Object[]>();
		Object[] tuple1Array = new Object[2];
		tuple1Array[0] = 2L;
		tuple1Array[1] = "India";
		tupleList.add(tuple1Array);
		return tupleList;
	}

	private List<Object[]> populateResultListWithMoreRecord() {
		List<Object[]> tupleList = new ArrayList<Object[]>();
		Object[] tuple1Array = new Object[2];
		tuple1Array[0] = 2L;
		tuple1Array[1] = "India";
		Object[] tuple2Array = new Object[2];
		tuple2Array[0] = 3L;
		tuple2Array[1] = "Britain";
		tupleList.add(tuple1Array);
		tupleList.add(tuple2Array);
		return tupleList;
	}
}
