package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class LoginPage extends TestBase{
		
	@FindBy(xpath="//input[@id='ap_email']") 
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public PasswordPage settxtEmail(String username) {
		txtEmail.sendKeys(username);
		continueBtn.click();
		return new PasswordPage();
	}
	
/*	public PasswordPage clickContinue() {
		continueBtn.click();
		return new PasswordPage();
	}*/
	
}
