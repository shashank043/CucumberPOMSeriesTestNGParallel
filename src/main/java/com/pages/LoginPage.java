package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1. By Locators : OR
	private By emailid=By.id("email");
	private By password=By.id("passwd");
	private By SignIn=By.id("SubmitLogin11");
	private By ForgotPwdLink=By.xpath("//a[contains(text(),'Forgot your password?')]");
	
	//2. Constructor of the page class
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//3. Page actions features(behaviors) of the page in the form of methods
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgetPasswordLinkExist()
	{
		return driver.findElement(ForgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(emailid).sendKeys(username);
	}
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickOnLogin()
	{
		driver.findElement(SignIn).click();
	}
	
	public AccountsPage doLogin(String un, String pwd)
	{
		System.out.println("Login with "+un+" and "+pwd);
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignIn).click();
		return new AccountsPage(driver);
	}
}
