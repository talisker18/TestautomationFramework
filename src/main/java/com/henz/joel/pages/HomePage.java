package com.henz.joel.pages;

import org.openqa.selenium.support.PageFactory;

import com.henz.joel.base.Base;

public class HomePage extends Base{
	
	//static values
	private final static String URL = "https://www.opencart.com/";

	public HomePage() {
		super(URL);
		PageFactory.initElements(webDriver, this); //init the page factory with all webelements of this instance and with our webdriver in Base.java
		//under the hood this does: email = webDriver.findElement(By.id("input-email")); password = webDriver.findElement(By.name("password")); ...and so on
	}
	
	/**
	 * action methods
	 * 
	 * */
	
	public void openHomePage() {
		System.out.println("----------new home page opened\n");
		super.openPage();
	}

}
