package com.hqly.main;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.hamcrest.MatcherAssert;
import org.mockito.ArgumentMatcher;

public class PresenterMatcher extends ArgumentMatcher<String>{

    @Override
    public boolean matches(Object argument) {
	String output = (String) argument;
	StringTokenizer tokenizer = new StringTokenizer(output, ",");
	assertEquals(4, tokenizer.countTokens());
	while(tokenizer.hasMoreTokens()){
	    String nextToken = tokenizer.nextToken();
	    MatcherAssert.assertThat("Key:1,Name:India,Code:IN,Capital:Delhi", is(containsString(nextToken)));
	}
	return true;
    }

}
