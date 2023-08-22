package com.w3schools.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeWrappers {

	public static WebDriver driver;
	
	// return the class name as a string
	public String className() {
		
		return this.getClass().getSimpleName() + " class, ";
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

		try { element.sendKeys(text); }catch(Exception ex) {
			
			System.out.println("problem in passing text to the webelement on " + className() + "typeText method");
			ex.printStackTrace();
		}
	}
	
	// closes all opened browsers
	public void closeAllBrowsers() {
		
		try { driver.quit(); }catch(Exception ex) {
			
			System.out.println("problem in closing the all browsers on " + className() + "closeAllBrowsers method");
			
			ex.printStackTrace();
		}
	}
	
	// close the current browser or tab
	public void closeBrowser() {
		
		try { driver.quit(); }catch(Exception ex) {
			
			System.out.println("problem in closing the all browser on " + className() + "closeBrowser method");
			
			ex.printStackTrace();
		}
	}
	
	// clear text from the input fields
	// parameter => element
	public void clearText(WebElement element) {
		
		try { element.clear(); }catch(Exception ex) {
			
			System.out.println("problem in clearing text on " + className() + "clearText method");
			
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

		try{ waitForMe(10).until(ExpectedConditions.visibilityOf(element)); }catch (Exception ex){
			

			System.out.println("problem in web driver wait on "+ className() +"visibleOfElement method");
			ex.printStackTrace();
		}
	}

	// pageTitle will return the title of the webpage as a String
	public String pageTitel(){

		try{ return driver.getTitle(); }catch (Exception ex){

			System.out.println("problem on getting the web page title on "+className()+"pageTitle method");
			ex.printStackTrace();
		}

		return "";
	}

	// returns the current URL as a String
	public String currentURL(){

		try{ return driver.getCurrentUrl(); }catch (Exception exception){

			System.out.println("problem on getting the current url on "+ className() + "currentURL method");
			exception.printStackTrace();
		}

		return "";
	}
	
	// return JavascriptExecutor object
	// parameter => localDriver, localDriver nothing but the WebDriver object
	public JavascriptExecutor javaScriptObj(WebDriver localDriver) {
		
		JavascriptExecutor js = null;
		
		try {js = (JavascriptExecutor) localDriver;}catch(Exception ex) {
			
			System.out.println("problem on creating object for Java Script Executor on "+ className() + "javaScriptObj method");
			ex.printStackTrace();
			}
		
		return js;
	}
	
	// this method will scroll web page the specific element, until element visible to the user
	// parameter => element
	public void scrollToElement(WebElement element) {
		
		try {
		
		javaScriptObj(driver).executeScript("arguments[0].scrollIntoView();", element);
		
		}catch (Exception ex) {
			
			System.out.println("problem on Java Script scrollIntoView on "+ className() + "scrollIntoView method");
			ex.printStackTrace();
		}
	}
	
	// return the Object of the select class
	// parameter => element
	public Select selectObj(WebElement element) {
		
		Select select = null;
		
		try{ select = new Select(element); }catch(Exception ex) {
			
			System.out.println("problem on creating object for select class on "+ className() + "selectObj method");
			ex.printStackTrace();
		}
		
		return select;
	}
	
	// this is used to select the drop down by visible text
	// parameter => (element, text)
	public void selectVisibleText(WebElement element, String text) {
		
		try{ selectObj(element).selectByVisibleText(text); }catch(Exception ex) {
			
			System.out.println("problem on selecting by visible text on "+ className() + "selectVisibleText method");
			ex.printStackTrace();
		}
	}
	
}
