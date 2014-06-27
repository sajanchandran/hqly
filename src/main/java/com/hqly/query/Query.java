package com.hqly.query;

import org.hibernate.Session;

public interface Query {

	String execute(Session session, String hql);
}
