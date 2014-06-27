package com.hqly.presenter;

import java.util.List;

/** Presenter to properly present empty result set.
 * @author chandrans1
 *
 */
public class EmptyResultPresenter extends Presenter {

	/* (non-Javadoc)
	 * @see com.hqly.presenter.Presenter#format(java.util.List)
	 */
	@Override
	public String format(List<?> list) {
		return "No Records Found";
	}

	@Override
	public String format(int rowsUpdated) {
		throw new UnsupportedOperationException();
	}

}
