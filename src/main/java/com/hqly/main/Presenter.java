package com.hqly.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**This class is responsible for rendering the output from QueryHelper.
 * @author sajan chandran
 *
 */
public class Presenter {

    /**This method reads throught the list, uses reflection to invoke correct methods 
     * and renders the output.
     * @param list
     * @return String
     */
    public String format(List<?> list) {
	StringBuilder builder = new StringBuilder();
	for (Object object : list) {
	    Method[] methods = object.getClass().getDeclaredMethods();
	    for (int i = 0; i < methods.length; i++) {
		if (methods[i].getName().startsWith("get")) {
		    String fieldName = methods[i].getName().replace("get", "");
		    try {
			Object fieldValue = methods[i].invoke(object,(Object[]) null);
			builder.append(fieldName + ":" + fieldValue + ",");
		    } catch (IllegalAccessException e) {
			e.printStackTrace();
		    } catch (IllegalArgumentException e) {
			e.printStackTrace();
		    } catch (InvocationTargetException e) {
			e.printStackTrace();
		    }
		}
	    }
	}
	String output = builder.toString();
	System.out.println(output);
	System.out.println(output.substring(0, output.length() - 1));
	return output.substring(0, output.length() - 1);
    }

}
