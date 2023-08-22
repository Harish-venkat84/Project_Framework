package com.w3schools.po_manager;

import org.openqa.selenium.WebDriver;

import com.w3schools.po_models.LoginPage;

public class PageObjectManager {

	public WebDriver driver;
	
	public LoginPage login;
	
	
	public PageObjectManager(WebDriver driver2) {
		
		if (driver == null) {
			
			this.driver = driver2;
		}
	}
	
	public LoginPage getLoginPage() {
		
		if (login == null) {
			
			login = new LoginPage(driver);
		}
		
		return login;
	}
	
	
}
