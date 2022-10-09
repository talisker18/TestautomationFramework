package com.henz.joel.testcases;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatingDemoTest {
	
	@RepeatedTest(3)
	void firstTest() {
		System.out.println("first test");
	}
	
	@RepeatedTest(value = 5, name = "Running repetition: {currentRepetition}. Total = {totalRepetitions}")
	@DisplayName("this is repeated test")
	void secondTest() {
		System.out.println("second test");
	}
	
	@RepeatedTest(3)
	void thirdTest(RepetitionInfo repetitionInfo) {
		System.out.println("third test");
		System.out.println("this code runs every rep");
		
		Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 2, () -> System.out.println("repetition no 2 is executed"));
	}
	

}
