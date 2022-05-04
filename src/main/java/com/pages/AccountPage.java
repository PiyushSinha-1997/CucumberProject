package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	
	private WebDriver driver;
	
	//Bylocators
	private By accountsections = By.xpath("//div[@id='center_column']/descendant::span");
	
	
	// Constructor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Page action
	public int getaccountsectioncount() {
		return driver.findElements(accountsections).size();
	}
	
	public List<String> getaccountssectionlist() {
		List<String> accountlist= new ArrayList<>();
		List<WebElement>credlist=driver.findElements(accountsections);
		for(WebElement e:credlist) {
		String text=e.getText();//Fetching text of element from UI --UI text more preferable than DOM text
		System.out.println(text);
		accountlist.add(text);//storing entire text in a list
			
		}
		return accountlist;
	}
	public String getAccountsPagetitle() {
	return driver.getTitle();
	}
	
}
