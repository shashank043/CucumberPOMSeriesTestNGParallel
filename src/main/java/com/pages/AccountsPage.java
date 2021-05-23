package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;
	
	private By accountsSection=By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount()
	{
	return driver.findElements(accountsSection).size();
	}
	
	public List<String> getAccountsSectionList()
	{
		List<String> accountsList=new ArrayList<String>();
		List<WebElement> accountssectionheader=driver.findElements(accountsSection);
		for(WebElement e: accountssectionheader)
		{
			String text=e.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		return accountsList;
	}
	
}
