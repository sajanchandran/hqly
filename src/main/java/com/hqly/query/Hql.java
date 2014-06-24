package com.hqly.query;

public class Hql {

	private String hql;

	public Hql(String hql) {
		this.hql = hql;
	}

	public boolean isTupleQuery() {
		//e.g from Country, States
		// from Country c, States s
		return hql.matches("^from\\s+\\w+(?:\\s+\\w+)?,(?:\\s*\\w+(?:\\s+\\w+)?,?)+");
	}
}
