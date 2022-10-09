package com.henz.joel.testcases;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.henz.joel.pages.AccountPage;

/*
 * we can also tag a class
 * 
 * */

/*
 * 
 * how to run for example only test tagged with 'sanity':
 * 
 * see pom file, use groups property in maven surefire configuration
 * 
 * */

@TestInstance(Lifecycle.PER_CLASS) //When using this mode, a new test instance will be created once per test class. With this we do not have to use static methods for example for @BeforeAll method
public class TagDemoTest {

	@BeforeAll
	public void beforeClass() {
		System.out.println("some tasks before each class\n");
	}
	
	@AfterAll
	public void afterClass() {
		System.out.println("some tasks after each class\n");
	}
	
	@BeforeEach
	public void beforeMethod() {
		System.out.println("some tasks before each method\n");
	}
	
	@AfterEach
	public void afterMethod() {
		System.out.println("some tasks after each method\n");
	}
	
	@Test
	@DisplayName("UseCase 1.0 - Title of login page")
	@Tag("sanity")
	public void firstTest() {
		System.out.println("sanity 1\n");
	}
	
	@Test
	@Tag("sanity")
	@Tag("acceptance")
	public void secondTest() {
		System.out.println("sanity 2, acceptance 1\n");
	}
	
	@Test
	@Tag("acceptance")
	public void thirdTest() {
		System.out.println("acceptance 2\n");
	}
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@ValueSource(ints = {1,5,6})
	@Tag("acceptance")
	public void intValues(int theParam) {
		System.out.println("acceptance 3; "+theParam);
	}
}
