package com.hqly.presenter;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;

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
		}else if(ClassUtils.isPrimitiveWrapper(list.get(0).getClass()) || list.get(0) instanceof String){
			return new ResultPresenter();
		}else{
			return new ResultPresenter();
		}
	}

}
