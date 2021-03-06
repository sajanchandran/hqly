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
		StringBuilder output = new StringBuilder();
		for (Object object : list) {
			formatTuples(output, object);
		}
		output = output.delete(output.length()-2, output.length());
		output.append(System.lineSeparator());
		return output.toString();
	}

	@Override
	public String format(int rowsUpdated) {
		throw new UnsupportedOperationException();
	}

}
