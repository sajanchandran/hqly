package com.hqly.presenter;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;

import com.google.common.base.Joiner;

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
				if(ClassUtils.isPrimitiveWrapper(tuplets.getClass()) || tuplets instanceof String){
					output.append(tuplets + ",");
				}
				output.append(System.lineSeparator());
			}
			for (Object tuplets : tuple) {
					output.append(convertObjectToString(tuplets));
					output.append(System.lineSeparator());
				}
		}
		return output.toString();
	}
}
