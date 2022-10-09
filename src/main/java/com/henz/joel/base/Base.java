package com.henz.joel.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.henz.joel.util.Browser;

public class Base {
	
	protected WebDriver webDriver; //use separate webdriver for each class. Maybe in some test we need to launch multiple pages
	protected static Properties prop;
	private WebDriverWait webDriverWait;
	private final static int WAIT_IN_SECONDS = 20;
	private final String url;
	private final String pageName = this.getClass().toString();
	private final static List<WebDriver> WEBDRIVER_COLLECTOR = new ArrayList<>();
	
	static { //only call once to get the properties
		prop = new Properties();
		
		try {
			final FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected Base(String url){ //only allow subclasses and classes from same package to call constructor
		this.url = url;
		this.init();
	}
	
	private void init() {
		System.out.println("----------start init of new "+this.pageName+"\n");
		final String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			this.webDriver = new ChromeDriver();
		}
		
		//define other browsers here
		//...
		
		
		WEBDRIVER_COLLECTOR.add(webDriver);
		this.webDriver.manage().window().maximize();
		this.webDriver.manage().deleteAllCookies();
		
		//setup wait helper (explicit wait)
		this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(WAIT_IN_SECONDS));
	}
	
	/**
	 * shared page action methods
	 * 
	 * */
	
	protected final void openPage() {
		this.webDriver.get(this.url);
	}
	
	protected final String getPageTitle() {
		return this.webDriver.getTitle();
	}
	
	protected final void clickOnElement(final WebElement webElement) {
		this.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
	}
	
	protected final void putTextIntoInputField(final String text, final WebElement inputField, final boolean clearInputField) {
		this.waitForElementToBePresent(inputField);
		
		if(clearInputField) {
			inputField.clear();
		}
		
		inputField.sendKeys(text);
	}
	
	protected final void waitForElementToBePresent(final WebElement webElement) {
		this.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public final void quitWebdriver() {
		System.out.println("----------quit webdriver of "+this.pageName+"\n");
		this.webDriver.quit();
	}
	
	public static final void quitAllWebDriversAndClearList() {
		System.out.println("----------quit all webdrivers\n");
		WEBDRIVER_COLLECTOR.forEach(WebDriver::quit);
		WEBDRIVER_COLLECTOR.clear();
	}
	
	/**
	 * other methods
	 * 
	 * */
	
	/*
	 * before using this method make sure that you have all necessary webdrivers in your project (add webdriver paths in config.properties)
	 * 
	 * */
	protected final void changeBrowser(final Browser browser) {
		switch (browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			this.webDriver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			this.webDriver = new FirefoxDriver();
		case INTERNETEXPLORER:
			System.setProperty("webdriver.ie.driver", prop.getProperty("iepath"));
			this.webDriver = new InternetExplorerDriver();
		default:
			break;
		}
	}
}
