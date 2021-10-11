package com.amazon.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();		
		homePage=new HomePage();
	}
	@Test(enabled=false)	
	public void homePageTitleTest() {
		String expected="Amazon.com. Spend less. Smile more.";
	    String actual=homePage.validatePageTitle();
	    Assert.assertEquals(actual,expected,"Title incorrect!!");
	}
	
	@Test(enabled=false)	
	public void logoTest() {
	boolean flag=homePage.validateLogo();
	Assert.assertTrue(flag);
	}
	
	@Test
	public void signIn() {
		//loginPage = homePage.clickSignin();
		loginPage=homePage.clickdrpDown();
	}
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/

}
