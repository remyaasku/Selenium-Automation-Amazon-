package com.amazon.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.AddToCartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PasswordPage;
import com.amazon.pages.ProductResultsPage;

public class ProductResultsPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	PasswordPage passwordPage;
	ProductResultsPage productResultPage;
	AddToCartPage addToCartPage;
	
	public ProductResultsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		homePage=new HomePage();
	    loginPage=homePage.clickdrpDown();
	    
	    loginPage=new LoginPage();
	    passwordPage =loginPage.settxtEmail(prop.getProperty("username"));
	    
	    passwordPage=new PasswordPage();
		homePage=passwordPage.setPassword(prop.getProperty("password"));
		
		homePage=new HomePage();
		productResultPage=homePage.settxtSearch(prop.getProperty("product"));
		
		
	}
	
	@Test
	public void selectProduct() {
		productResultPage=new ProductResultsPage();
		addToCartPage=productResultPage.selectproduct();
	}	
		
		
	}


