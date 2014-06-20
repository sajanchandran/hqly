package com.hqly.main;

import java.util.List;

import org.hibernate.Session;

public class QueryHelper {

    private Session session;

    public void setSession(Session session) {
    	this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<Object> execute(String hql) {
    	return session.createQuery(hql).list();
    }

}
