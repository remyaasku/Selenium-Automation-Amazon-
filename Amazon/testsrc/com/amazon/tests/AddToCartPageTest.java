package com.amazon.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.AddToCartPage;
import com.amazon.pages.CheckoutPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PasswordPage;
import com.amazon.pages.ProductResultsPage;

public class AddToCartPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	PasswordPage passwordPage;
	ProductResultsPage productResultPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	
	public AddToCartPageTest() {
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
		
		homePage=new HomePage();
		productResultPage=homePage.settxtSearch(prop.getProperty("product"));
		
		productResultPage=new ProductResultsPage();
		addToCartPage=productResultPage.selectproduct();		
		
	}
	
	@Test
	public void addToCartClick() {
		addToCartPage=new AddToCartPage();
		checkoutPage=addToCartPage.clickAddToCart();
		
		String expected="Added to Cart";
		String actual="";
		try {
			actual=driver.findElement(By.xpath("//span[contains(text(),'Added to Cart')]")).getText();
		}
		catch(Exception e) {
			
		}
		Assert.assertEquals(actual, expected,"Product not added");
	}
	
/*	@AfterMethod
	public void tearDown() {
		driver.quit();
	}*/

}
