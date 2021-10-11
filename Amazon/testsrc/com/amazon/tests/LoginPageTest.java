package com.amazon.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PasswordPage;

public class LoginPageTest  extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	PasswordPage passwordPage;
	
	//PasswordPage passwordPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
	    loginPage=homePage.clickdrpDown();
	}
	
	@Test(priority=1)
	public void validatePageTitle() {
		String expected="Amazon Sign-In";
		String actual=loginPage.validatePageTitle();
		Assert.assertEquals(actual,expected,"Wrong Page!");
	}
	
	@Test(priority=2)
	public void doLogin() {
	loginPage=new LoginPage();
	passwordPage=loginPage.settxtEmail(prop.getProperty("username"));
	passwordPage=new PasswordPage();
	homePage=passwordPage.setPassword(prop.getProperty("password"));
  //  passwordPage=loginPage.clickContinue();
}
	
	
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/
	
}
