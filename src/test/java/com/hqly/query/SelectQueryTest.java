package com.hqly.query;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

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
import com.hqly.presenter.TupleResultPresenter;
import com.hqly.presenter.UpdateResultPresenter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/database.xml",
		"classpath:spring/config.xml" })
public class SelectQueryTest {

	@Mock
	private PresenterFactory mockPresenterFactory;

	@Autowired
	private SessionFactory sessionFactory;

	private Presenter mockPresenter;

	@Before
	public void onceBeforeEachTest() {
		initMocks(this);
		mockPresenter = mock(TupleResultPresenter.class);
		when(mockPresenterFactory.getPresenter(anyList())).thenReturn(mockPresenter);
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
		Query query = new SelectQuery(mockPresenterFactory);
		Session session = sessionFactory.openSession();
		query.execute(session, "select c from Country c");
		verify(mockPresenterFactory, times(1)).getPresenter(anyList());
	}
}
