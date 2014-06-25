package com.hqly.query;

import java.util.List;

import org.hibernate.Session;

public class QueryHelper {

    private Session session;

    public void setSession(Session session) {
    	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Object> select(String hql) {
    	return session.createQuery(hql).list();
    }

	public int update(String hql) {
		return session.createQuery(hql).executeUpdate();
	}
}
