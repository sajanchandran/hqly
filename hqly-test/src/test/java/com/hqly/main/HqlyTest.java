package com.hqly.main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
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
public class HqlyTest {

    @Autowired
    private SessionFactory sessionFactory;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    
    @Before
    public void onceBeforeEachTest(){
	Session session = sessionFactory.openSession();
	SQLQuery query = session.createSQLQuery("insert into t_country values (1, 'India','IN', 'DELHI')");
	query.executeUpdate();
	session.close();
    }
    
    @After
    public void onceAfterEachTest(){
	System.setOut(null);
	Session session = sessionFactory.openSession();
	SQLQuery query = session.createSQLQuery("delete from t_country");
	query.executeUpdate();
	session.close();	
    }
    
    @Test
    public void executeQuery(){
	System.setOut(new PrintStream(output));
	Hqly.main(new String[]{"from Country"});
	Assert.assertEquals("hello", output.toString());
    }
}
