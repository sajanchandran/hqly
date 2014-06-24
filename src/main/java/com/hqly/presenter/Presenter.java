package com.hqly.presenter;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;
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
	
	protected void formatTuples(StringBuilder output, Object tuplets) {
		if(ClassUtils.isPrimitiveWrapper(tuplets.getClass()) || tuplets instanceof String){
			output.append(tuplets);
			output.append(", ");
		}else{
			output.append(convertObjectToString(tuplets));
		}
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
			buffer.delete(buffer.length()-2, buffer.length());
			buffer.append(System.lineSeparator());
		}
		
		@Override
		protected void appendFieldStart(StringBuffer buffer, String fieldName) {
			super.appendFieldStart(buffer, StringUtils.capitalize(fieldName));
		}
		
		@Override
		protected void appendFieldEnd(StringBuffer buffer, String fieldName) {
			super.appendFieldEnd(buffer, fieldName);
			buffer.append(" ");
		}
	}
}
