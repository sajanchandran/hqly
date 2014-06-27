package com.hqly.query;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

public class QueryFactoryTest {

	@Test
	public void fromQueryReturnsSelectQuery(){
		Query query = QueryFactory.get("from Country");
		assertThat(query, IsInstanceOf.instanceOf(SelectQuery.class));
	}
	
	@Test
	public void selectQueryReturnsSelectQuery(){
		Query query = QueryFactory.get("select c from Country c");
		assertThat(query, IsInstanceOf.instanceOf(SelectQuery.class));
	}
	
	@Test
	public void insertQueryReturnsUpdateQuery(){
		Query query = QueryFactory.get("insert into Country");
		assertThat(query, IsInstanceOf.instanceOf(UpdateQuery.class));
	}
	
	@Test
	public void updateQueryReturnsUpdateQuery(){
		Query query = QueryFactory.get("update Country set");
		assertThat(query, IsInstanceOf.instanceOf(UpdateQuery.class));
	}
	
	@Test
	public void deleteQueryReturnsUpdateQuery(){
		Query query = QueryFactory.get("delete Country where");
		assertThat(query, IsInstanceOf.instanceOf(UpdateQuery.class));
	}
}
