package com.henz.joel.testcases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.henz.joel.listeners.Listener;


@ExtendWith(Listener.class)
public class TestListenerDemoTest {
	
	@Test
	void firstTest() {
		Assertions.assertTrue(true);
	}
	
	@Test
	void secondTest() {
		Assertions.assertTrue(false);
	}

}
