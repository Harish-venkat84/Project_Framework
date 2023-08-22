package com.w3schools.tests;

import org.testng.annotations.Test;

import com.w3schools.po_manager.PageObjectManager;
import com.w3schools.property.FileReaderManager;
import com.w3schools.utils.SeWrappers;

public class LoginTest extends SeWrappers{

	public PageObjectManager pom = new PageObjectManager(driver);
	
	public FileReaderManager property = new FileReaderManager();
	
	@Test
	public void login() {
		
		launchBrowser("chrome", "https://profile.w3schools.com/");
		
		visibleOfElement(pom.getLoginPage().getMailID());
		
		typeText(pom.getLoginPage().getMailID(), property.getMailID());
		
		typeText(pom.getLoginPage().getPassword(), property.getPass());
		
		clickButton(pom.getLoginPage().getLoginButton());
	}
	
}
