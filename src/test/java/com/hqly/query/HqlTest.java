package com.hqly.query;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HqlTest {

	@Test
	public void isTupleQueryWithAlias(){
		Hql hql = new Hql("from Country c, Continent cn");
		assertThat(hql.isTupleQuery(), is(true));
	}
	
	@Test
	public void isTupleQueryWithoutAlias(){
		Hql hql = new Hql("from Country, Continent");
		assertThat(hql.isTupleQuery(), is(true));
	}
}
