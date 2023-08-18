package com.w3schools.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

	public static WebDriver driver;
	
	// return the class name as a string
	public String className() {
		
		return this.getClass().getSimpleName();
	}
	
	
	// this method is user for browser launch
	// parameter ==> (browser -> name), (url -> application url)
	public void launchBrowser(String browser, String url) {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
			
		} else if (browser.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
	}
	
	// this method is used to pass text to the input field
	// parameters => (element, text)
	public void typeText(WebElement element,String text) {

		try {
			
			element.sendKeys(text);
			
		}catch(Exception ex) {
			
			System.out.println("problem in passing text to the webelement on " + className() + " Class, typeText method");
			ex.printStackTrace();
		}
	}
	
	// closes all opened browsers
	public void closeAllBrowsers() {
		
		try {
			
			driver.quit();
			
		}catch(Exception ex) {
			
			System.out.println("problem in closing the all browsers on " + className() + "class, closeAllBrowsers method");
			
			ex.printStackTrace();
		}
	}
	
	// close the current browser or tab
	public void closeBrowser() {
		
		try {
			
			driver.quit();
			
		}catch(Exception ex) {
			
			System.out.println("problem in closing the all browser on " + className() + "class, closeBrowser method");
			
			ex.printStackTrace();
		}
	}
	
	// clear text from the input fields
	// parameter => element
	public void clearText(WebElement element) {
		
		try {
			
			element.clear();
		
		}catch(Exception ex) {
			
			System.out.println("problem in clearing text on " + className() + " class, clearText method");
			
			ex.printStackTrace();
		}
	}
	
	// WebDriverWait object return
	// parameter => timeout
	public WebDriverWait waitForMe(long timeout) {

		return new WebDriverWait(driver, Duration.ofSeconds(timeout));

	}

	// This method wait based on the visibility of WebElement
	// parameter => element
	public void visibleOfElement(WebElement element){

		try{

			waitForMe(10).until(ExpectedConditions.visibilityOf(element));

		}catch (Exception ex){

			System.out.println("problem in web driver wait on "+ className() +" class, visibleOfElement method");
			ex.printStackTrace();
		}
	}

	public String pageTitel(){

		String title = "";

		try{

			title = driver.getTitle();

		}catch (Exception ex){

			System.out.println("problem on getting the web page title on "+className()+" class, pageTitle method");
			ex.printStackTrace();
		}

		return title;
	}

	public String currentURL(){

		try{

			return driver.getCurrentUrl();
		}catch (Exception exception){

			System.out.println("problem on getting the current url on "+ className() +" class, currentURL method");
			exception.printStackTrace();
		}

		return "";
	}
}
