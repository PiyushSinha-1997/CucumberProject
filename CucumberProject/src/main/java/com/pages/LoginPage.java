package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//By locators
	private By emailId= By.id("email");
	private By pwd= By.id("passwd");
	private By signInbtn= By.id("SubmitLogin");
	private By Forgotpwdlink = By.linkText("Forgot your password?");
	
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Page Action means features(behaviour) of the page
	
	public String getLoginPageTitle() {
	return driver.getTitle();
	}
	
	
	public boolean Forgotpwdlinkdisplayed()
	{
	return driver.findElement(Forgotpwdlink).isDisplayed();	
	}
	
	public void enterusername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterpassword(String password) {
		driver.findElement(pwd).sendKeys(password);
		}
	public void clickonLogin() {
		driver.findElement(signInbtn).click();
	}
	 public AccountPage doLogin(String un, String pass) {
		 driver.findElement(emailId).sendKeys(un);
		 driver.findElement(pwd).sendKeys(pass);
		 driver.findElement(signInbtn).click();
		 return new AccountPage(driver);
	 }
}
