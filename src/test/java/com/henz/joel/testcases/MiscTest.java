package com.henz.joel.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.Timeout;

/*
 * timeouts
 * 
 * inner class tests (nested test class)
 * 
 * custom annotations
 * */

public class MiscTest {
	
	@Test
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void timeoutDemo() {
		
	}
	
	@Test
	@Timeout(value = 90, unit = TimeUnit.SECONDS)
	@DisplayName("test2")
	void annotatedMethod1() {
		
	}
	
	@MyAnnotation //custom annotation containing multiple other annotations
	void annotatedMethod2() {
		
	}
	
	
	@TestInstance(Lifecycle.PER_CLASS)
	@Nested
	class NestedTest{
		
		@BeforeAll
		void beforeAll() {
			System.out.println("before all");
		}
		
		@Test
		void nestedTest() {
			
		}
	}

}
