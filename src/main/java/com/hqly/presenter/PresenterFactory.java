package com.hqly.presenter;

import java.util.List;

/**Factory to determine the type of presenter to be used, based on the 
 * result set from the database.
 * @author chandrans1
 *
 */
public class PresenterFactory {

	/**
	 * @param list
	 * @return instance of Presenter
	 */
	public Presenter getPresenter(List<?> list) {
 		if(list == null || list.size() == 0){
			return new EmptyResultPresenter();
		}else if(list.get(0) instanceof Object[]){
			return new TupleResultPresenter();
		}else{
			return new ResultPresenter();
		}
	}

	public Presenter getPresenter(String hql) {
		//eg. from country
		if(hql.matches("^from[^,]+")){
			return new ResultPresenter();
		//eg. from country, states	
		}else if(hql.matches("^from\\s+\\w+,(?:\\s*\\w+,?)+")){
			return new TupleResultPresenter();
		}
		return null;
	}

}
