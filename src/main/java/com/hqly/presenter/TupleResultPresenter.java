package com.hqly.presenter;

import java.util.List;

/** Class responsible for rendering if the user requested individual tuples.
 * @author chandrans1
 *
 */
public class TupleResultPresenter extends Presenter{

	/* (non-Javadoc)
	 * @see com.hqly.presenter.Presenter#format(java.util.List)
	 */
	@Override
	public String format(List<?> list) {
		StringBuilder output = new StringBuilder();
		for (Object object : list) {
			Object[] tuple = (Object[]) object;
			for (Object tuplets : tuple) {
				formatTuples(output, tuplets);
			}
			output = output.delete(output.length()-2, output.length());
			output.append(System.lineSeparator());
		}
		return output.toString();
	}

	@Override
	public String format(int rowsUpdated) {
		throw new UnsupportedOperationException();
	}
	
}
