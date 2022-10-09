package com.henz.joel.testcases;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.asynchttpclient.util.HttpConstants.Methods;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.henz.joel.base.Base;
import com.henz.joel.pages.AccountPage;
import com.henz.joel.pages.HomePage;
import com.henz.joel.pages.LoginPage;

@TestMethodOrder(MethodOrderer.MethodName.class) //run tests ordered alpha numeric. but the displayName is not regarded for ordering
//if we want to order with displayName: @TestMethodOrder(MethodOrderer.DisplayName.class)
//we can also use OrderAnnotation.class and add @Order(1) 2,3 etc to the test methods
@TestInstance(Lifecycle.PER_CLASS) //When using this mode, a new test instance will be created once per test class. With this we do not have to use static methods for example for @BeforeAll method
@Disabled
public class LoginPageTest{
	
	private LoginPage loginPage;
	private HomePage homePage;
	
	//expected values
	private static final String EXPECTED_TITLE = "OpenCart - Account Login";
	
	@BeforeAll
	public void beforeClass() {
		System.out.println("some tasks before each class\n");
	}
	
	@AfterAll
	public void afterClass() {
		System.out.println("some tasks after each class\n");
	}
	
	@BeforeEach
	public void setUp() {
		this.loginPage = new LoginPage();
		this.loginPage.openLoginPage();
		
		//just open other page. There should be 2 browser tabs now
		this.homePage = new HomePage();
		this.homePage.openHomePage();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterEach
	public void tearDown() {
		//close single webdrivers or call quitAllWebDriversAndClearList() method
		//this.loginPage.quitWebdriver();
		//this.homePage.quitWebdriver();
		Base.quitAllWebDriversAndClearList();
	}
	
	@Test
	@DisplayName("UseCase 1.0 - Title of login page")
	public void loginPageTitleTest() {
		final String actualTitle = this.loginPage.getLoginPageTitle();
		Assertions.assertThat(actualTitle).isEqualTo(EXPECTED_TITLE);
	}
	
	@Test
	@DisplayName("UseCase 1.1 - Perform Login")
	public void performLogin() {
		final String email = this.loginPage.getUserEmail();
		final String password = this.loginPage.getUserPassword();
		
		AccountPage accountPage= this.loginPage.performLogin(email, password);
		//do checks if AccountPage is visible...
	}
	
	/**
	 * test data driven tests
	 * 
	 * */
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@ValueSource(ints = {1,5,6})
	public void intValues(int theParam) {
		System.out.println(theParam);
	}
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@NullAndEmptySource //only use with objects. Inject 1 null and 1 empty value...you can also use null and empty source separately
	@ValueSource(strings = {"first","second","third"})
	public void stringValues(String theParam) {
		System.out.println(theParam);
	}
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@CsvSource(value = {"steve,rogers","captain,marvel","bucky,barnes"})
	public void csvValues(String firstName, String lastName) {
		System.out.println(firstName+"; "+lastName);
	}
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@CsvSource(value = {"steve,32,true","captain,44,true","bucky,22,false"})
	public void csvValuesWithStringIntBoolean(String str, int i, boolean b) {
		System.out.println(str+"; "+i+"; "+b);
	}
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@CsvSource(value = {"captain america,'steve, rogers'","winter soldier,'bucky, barnes'"})
	public void csvValuesWithStringContainingComma(String str1, String str2) {
		System.out.println(str1+"; "+str2);
	}
	
	//other delimiter, for example ?
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@CsvSource(value = {"steve?rogers","captain?marvel","bucky?barnes"}, delimiter = '?')
	public void csvValuesOtherDelimiter(String str1, String str2) {
		System.out.println(str1+"; "+str2);
	}
	
	@ParameterizedTest
	@MethodSource(value = "sourceString")
	public void methodSource_string(String param1) {
		System.out.println("param1: "+param1);
	}
	
	public List<String> sourceString(){
		return Arrays.asList("tomato","carrot","cabbage");
	}
	
	@ParameterizedTest
	@MethodSource(value = "sourceStringAsStream")
	public void methodSource_stringStream(String param1) {
		System.out.println("param1: "+param1);
	}
	
	public Stream<String> sourceStringAsStream(){
		return Stream.of("stream1","stream2","stream3");
	}
	
	@ParameterizedTest
	@MethodSource(value = "sourceList_StringDouble")
	public void methodSourceList_StringDouble(String param1, double param2) {
		System.out.println(param1+"; "+param2);
	}
	
	public List<Arguments> sourceList_StringDouble(){ //or use Stream instead if List
		return Arrays.asList(
				Arguments.arguments("tomato", 2.0), 
				Arguments.arguments("carrot", 3.5), 
				Arguments.arguments("cabbage", 5.3)
				);
	}
	
	//if we want to put these method sources into other class, like for example ParamProvider.java, there we have to make the source static
	//in the the, access the source as follows
	@ParameterizedTest
	@MethodSource(value = "com.henz.joel.testcases.ParamProvider#sourceList_StringDoubleStream")
	public void methodSourceList_StringDoubleStream(String param1, double param2) {
		System.out.println(param1+"; "+param2);
	}
	
	
	
}
