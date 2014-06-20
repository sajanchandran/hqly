package com.hqly.presenter;

import java.util.List;

/**
 * This class is responsible for rendering the output from QueryHelper.
 * 
 * @author sajan chandran
 * 
 */
public class ResultPresenter extends Presenter{

	/**
	 * This method reads throught the list, uses reflection to invoke correct
	 * methods and renders the output.
	 * 
	 * @param list
	 * @return String
	 */
	@Override
	public String format(List<?> list) {
		StringBuilder builder = new StringBuilder();
		for (Object object : list) {
			builder.append(convertObjectToString(object));
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

}
