package com.henz.joel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.henz.joel.base.Base;

public class LoginPage extends Base{
	
	//page factory
	@FindBy(id = "input-email")
	private WebElement emailInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(xpath = "//*[@id=\"account-login\"]/div[2]/div/div[1]/form/div[3]/div[1]/button[1]")
	private WebElement submitLogin;
	
	@FindBy(xpath = "/html/body/header/nav/div/div[2]/div/a[2]") // full xpath
	private WebElement registerButton;
	
	//static values
	private final static String URL = "https://www.opencart.com/index.php?route=account/login";
	
	public LoginPage() {
		super(URL);
		PageFactory.initElements(super.webDriver, this); //init the page factory with all webelements of this instance and with our webdriver in Base.java
		//under the hood this does: email = webDriver.findElement(By.id("input-email")); password = webDriver.findElement(By.name("password")); ...and so on
	}
	
	/**
	 * page action methods
	 * 
	 * */
	
	public final String getLoginPageTitle() {
		return super.getPageTitle();
	}
	
	public final AccountPage performLogin(String email, String password) {
		this.inputEmail(email);
		this.inputPassword(password);
		this.clickOnSubmitButton();
		
		return new AccountPage(false);
	}
	
	/*
	 * ATTENTION: email and password are clear text in config.properties
	 * 
	 * in production, use local file NOT in project folder for local testing 
	 * or save the credentials for example in Jenkins when using a Build Pipeline
	 * 
	 * */
	public final void openLoginPage() {
		System.out.println("----------new login page opened\n");
		super.openPage();
	}
	
	public final String getUserEmail() {
		return prop.getProperty("email");
	}
	
	public final String getUserPassword() {
		return prop.getProperty("password");
	}
	
	/**
	 * Helper methods
	 * 
	 * */
	private void inputEmail(String email) {
		putTextIntoInputField(email, this.emailInput, true);
	}
	
	private void inputPassword(String password) {
		putTextIntoInputField(password, this.passwordInput, true);
	}
	
	private void clickOnSubmitButton() {
		clickOnElement(this.submitLogin);
	}
}
