package com.henz.joel.testcases;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class AssertionDemoTest {

	@Test
	void assertEqualsTest() {
		Assertions.assertEquals("firstString", "secondString", "message in case tests fails");
	}
	
	@Test
	void assertEqualsListTest() { //check items and position in lists
		List<String> expectedList = Arrays.asList("firstString","secondString");
		List<String> actualList = Arrays.asList("firstString","secondString");
		Assertions.assertEquals(expectedList, actualList, "message in case tests fails");
	}
	
	@Test
	void assertArraysEqualsTest() {  //order also matters in arrays
		int[] expected = {1,2,3};
		int[] actual = {1,2,3};
		Assertions.assertEquals(expected, actual, "message in case tests fails");
	}
	
	@Test
	void assertTrueTest() {
		Assertions.assertFalse(false);
		Assertions.assertTrue(true);
	}
	
	@Test
	void assertThrowsTest() {
		Assertions.assertThrows(NullPointerException.class, null);
	}
	
	@Test
	void assertAllTest() {
		Assertions.assertAll(
				() -> Assertions.assertEquals(1, 2),
				() -> Assertions.assertEquals("hello", "world"),
				() -> Assertions.assertTrue(true),
				() -> Assertions.assertFalse(false)
				);
	}
}
