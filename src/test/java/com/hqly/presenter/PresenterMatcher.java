package com.hqly.presenter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.mockito.ArgumentMatcher;

public class PresenterMatcher extends ArgumentMatcher<String>{

	private long recordsCount;

	public PresenterMatcher(long recordsCount) {
		this.recordsCount = recordsCount;
	}
	
    @Override
    public boolean matches(Object argument) {
		String output = (String) argument;
		System.out.println(output);
		StringTokenizer tokenizer = new StringTokenizer(output, ",");
		assertEquals(recordsCount, tokenizer.countTokens());
		while(tokenizer.hasMoreTokens()){
		    String nextToken = tokenizer.nextToken();
		    assertThat("Key:1,Name:India,Code:IN,Capital:Delhi", is(containsString(nextToken)));
		}
		return true;
    }
}
