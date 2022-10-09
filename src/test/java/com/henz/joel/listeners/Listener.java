package com.henz.joel.listeners;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

/*
 * see TestListenerDemoTest
 * 
 * */

public class Listener implements TestWatcher{
	
	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		System.out.println("-----------------------");
		System.out.println("this test was disabled: "+context.getTestMethod() + " with reason "+reason);
	}

	@Override
	public void testSuccessful(ExtensionContext context) {
		System.out.println("-----------------------");
		System.out.println("this test was successful: "+context.getTestMethod());
	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
		System.out.println("-----------------------");
		System.out.println("this test was aborted: "+context.getTestMethod()+" with cause "+cause.getMessage());
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		System.out.println("-----------------------");
		System.out.println("this test was failed: "+context.getTestMethod()+" with cause "+cause.getMessage());
	}

}
