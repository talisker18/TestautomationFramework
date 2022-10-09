package com.henz.joel.testcases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class AssertionHamcrestDemoTest {

	@Test
	void assertForMapTest() {
		Map<String,Integer> map1 = new HashMap<>();
		
		map1.put("first", 1);
		map1.put("second", 2);
		map1.put("third", 3);
		MatcherAssert.assertThat(map1, Matchers.hasKey("first"));
		MatcherAssert.assertThat(map1, Matchers.hasValue(2));
	}
	
	@Test
	void assertForListTest() {
		List<String> list = Arrays.asList("first","second");
		MatcherAssert.assertThat(list, Matchers.hasItem("first"));
	}
	
	@Test
	void assertForAnyOfListTest() {
		List<String> list = Arrays.asList("first","second");
		MatcherAssert.assertThat(list, Matchers.anyOf( //any of the following should be true to pass the test
				Matchers.hasItem("first"),
				Matchers.hasItem("world")
				));
		
		MatcherAssert.assertThat(list, Matchers.allOf( //this will fail because all should be true to pass the test
				Matchers.hasItem("first"),
				Matchers.hasItem("world")
				));
	}
	
	@Test
	void assertForContainsAnyOrder() {
		List<String> list = Arrays.asList("first","second");
		MatcherAssert.assertThat(list, Matchers.containsInAnyOrder("second","first")); //ignores the order. so this test will pass
	}
}
