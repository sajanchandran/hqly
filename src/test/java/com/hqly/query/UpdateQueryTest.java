package com.hqly.query;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.hamcrest.core.Is;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hqly.presenter.Presenter;
import com.hqly.presenter.PresenterFactory;
import com.hqly.presenter.UpdateResultPresenter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/database.xml",
		"classpath:spring/config.xml" })
public class UpdateQueryTest {

	@Mock
	private PresenterFactory mockPresenterFactory;

	@Autowired
	private SessionFactory sessionFactory;

	private Presenter mockPresenter;

	@Before
	public void onceBeforeEachTest() {
		initMocks(this);
		mockPresenter = mock(UpdateResultPresenter.class);
		when(mockPresenterFactory.getPresenter(1)).thenReturn(mockPresenter);
		Session session = sessionFactory.openSession();
		SQLQuery query = session
				.createSQLQuery("insert into t_country values (1, 'India','IN', 'DELHI')");
		query.executeUpdate();
		session.close();
	}

	@After
	public void onceAfterEachTest() {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("delete from t_country");
		query.executeUpdate();
		session.close();
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void executeQuery(){
		UpdateQuery query = new UpdateQuery(mockPresenterFactory);
		Session session = sessionFactory.openSession();
		query.execute(session, "update Country c set c.name='bharath' where c.key=1");
		List<String> list = session.createSQLQuery("select name from t_country where key=1").list();
		assertThat(list.get(0), Is.is("bharath"));
	}
	
	@Test
	public void presenterFactoryInvokesCorrectly(){
		UpdateQuery query = new UpdateQuery(mockPresenterFactory);
		Session session = sessionFactory.openSession();
		query.execute(session, "update Country c set c.name='bharath' where c.key=1");
		verify(mockPresenterFactory, timeout(1)).getPresenter(1);
	}
	
	@Test
	public void presenterInvokesCorrectly(){
		UpdateQuery query = new UpdateQuery(mockPresenterFactory);
		Session session = sessionFactory.openSession();
		query.execute(session, "update Country c set c.name='bharath' where c.key=1");
		verify(mockPresenter, timeout(1)).format(1);
	}
}
