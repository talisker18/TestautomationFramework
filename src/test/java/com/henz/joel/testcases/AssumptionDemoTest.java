package com.henz.joel.testcases;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * see also: RepeatingTestDemo
 * 
 * */

public class AssumptionDemoTest {

	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@ValueSource(ints = {1,5,6})
	public void intValues(int theParam) {
		Assumptions.assumeTrue(theParam > 4); //run test only if theParam > 4
		System.out.println(theParam);
	}
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@CsvSource(value = {"steve,rogers","captain,marvel","bucky,barnes"})
	public void csvValues(String firstName, String lastName) {
		Assumptions.assumeFalse(firstName.equals("steve"), "Print this message when assumption failed"); // dont run test if firstName = steve
		System.out.println(firstName+"; "+lastName);
	}
	
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@CsvSource(value = {"steve,32,true","captain,44,true","bucky,22,false"})
	public void csvValuesWithStringIntBoolean(String str, int i, boolean b) {
		//attention: we do NOT skip tests here!! if assumption is true, run some additional code
		Assumptions.assumingThat(i > 30, () -> System.out.println("execute every test, but print this message only when condition is true"));
		System.out.println(str+"; "+i+"; "+b);
	}
}
