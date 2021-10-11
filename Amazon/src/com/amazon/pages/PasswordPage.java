package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class PasswordPage extends TestBase {
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signinbuton;
	
	public PasswordPage() {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public HomePage setPassword(String password) {
		txtpassword.sendKeys(password);
		signinbuton.click();
		return new HomePage();
	}

}
