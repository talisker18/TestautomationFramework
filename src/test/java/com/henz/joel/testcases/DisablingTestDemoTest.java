package com.henz.joel.testcases;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class DisablingTestDemoTest {
	
	static {
		System.setProperty("env", "prod");
	}
	
	@Test
	@Disabled(value = "demo1")
	void firstTest() {
		System.out.println("first test");
	}
	
	@Test
	@DisabledOnOs(value = OS.WINDOWS, disabledReason = "some reason") // disable on specific OS. you can also use @Enabled
	void secondTest() {
		System.out.println("second test");
	}
	
	@Test
	@DisabledIfSystemProperty(named = "env", matches = "prod") // disable if env = prod. env should be defined in the run configurations or call System.setProperty("env", "prod"); --> in static block
	void thirdTest() {
		System.out.println("third test");
		//System.setProperty("env", "prod");
	}
	
	@Test
	@DisabledIf(value = "provider", disabledReason = "some reason")
	void fourthTest() {
		System.out.println("fourth test");
	}
	
	boolean provider() {
		return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY);
	}
	
	@Test
	void fifthTest() {
		System.out.println("fifth test");
	}

}
