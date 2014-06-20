package com.hqly.presenter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**Interface which custom presenter should implement to display the result
 * accordingly
 * @author chandrans1
 *
 */
public abstract class Presenter {

	/** Custom presenter class should override the method to format the output result
	 * set for the user.
	 * @param list
	 * @return String (to display in the command line output)
	 */
	public abstract String format(List<?> list);
	
	/**
	 * @param object
	 * @return
	 */
	public String convertObjectToString(Object object){
		return ToStringBuilder.reflectionToString(object, new CustomToStringStyle());
	}
	
	@SuppressWarnings("serial")
	private class CustomToStringStyle extends ToStringStyle {
		@Override
		protected void appendClassName(StringBuffer buffer, Object object) {
		}
		
		@Override
		protected void appendIdentityHashCode(StringBuffer buffer, Object object) {
		}

		@Override
		protected void appendContentStart(StringBuffer buffer) {
		}
		
		@Override
		protected void appendContentEnd(StringBuffer buffer) {
		}
		
		@Override
		protected void appendFieldStart(StringBuffer buffer, String fieldName) {
			super.appendFieldStart(buffer, StringUtils.capitalize(fieldName));
		}
	}
}
