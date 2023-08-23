package com.w3schools.po_models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class LoginPage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@name = 'email']")
	private WebElement mailID;

	@FindBy(xpath = "//input[@id = 'current-password']")
	private WebElement password;

	@FindBy(xpath = "//span[text() = 'Log in']//parent::button")
	private WebElement loginButton;

	public LoginPage(WebDriver driver2) {

		if (driver == null) {

			this.driver = driver2;

			PageFactory.initElements(driver2, this);
		}
	}
	
	

}
