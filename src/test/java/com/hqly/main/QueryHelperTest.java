package com.hqly.main;

import static org.junit.Assert.assertEquals;


import org.hibernate.SQLQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath:spring/database.xml",
	"classpath:spring/config.xml"
	})
public class QueryHelperTest {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Before
    public void onceBeforeEachTest(){
	Session session = sessionFactory.openSession();
	SQLQuery query = session.createSQLQuery("insert into t_country values (1, 'India','IN', 'DELHI')");
	query.executeUpdate();
	session.close();
    }
    
    @After
    public void onceAfterEachTest(){
	Session session = sessionFactory.openSession();
	SQLQuery query = session.createSQLQuery("delete from t_country");
	query.executeUpdate();
	session.close();
    }
    
    @Test
    public void selectQuery(){
	QueryHelper ui = new QueryHelper();
	ui.setSession(sessionFactory.openSession());
	List<Object> output = ui.execute("from Country");
	assertEquals(1, output.size());
    }
}
