package com.amazon.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PasswordPage;
import com.amazon.pages.ProductResultsPage;

public class ProductSearchPageTest extends TestBase {
	
	
	HomePage homePage;
	LoginPage loginPage;
	PasswordPage passwordPage;
	ProductResultsPage productResultPage;
	
	public ProductSearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		homePage=new HomePage();
	    loginPage=homePage.clickdrpDown();
	    
	    loginPage=new LoginPage();
	    passwordPage =loginPage.settxtEmail(prop.getProperty("username"));
	    
	    passwordPage=new PasswordPage();
		homePage=passwordPage.setPassword(prop.getProperty("password"));
	  
	  
	}
	
	@Test
	public void searchProduct() {
		homePage=new HomePage();
		productResultPage=homePage.settxtSearch(prop.getProperty("product"));
		
		String expected="\"latest samsung phone 2021\"";
		String actual="";
		try {
			actual=driver.findElement(By.xpath("//span[contains(text(),'latest samsung phone 2021')]")).getText();
		}
		catch(Exception e) {
			
		}
		
		Assert.assertEquals(actual, expected,"Search results incorrect");
		
	}
	
	/*@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/
	
	

}
