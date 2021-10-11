package com.amazon.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.AddToCartPage;
import com.amazon.pages.CardDetailsPage;
import com.amazon.pages.CheckoutPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PasswordPage;
import com.amazon.pages.PaymentPage;
import com.amazon.pages.ProductResultsPage;

public class PaymentPageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	PasswordPage passwordPage;
	ProductResultsPage productResultPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	PaymentPage paymentPage;
    CardDetailsPage cardDetailsPage;
	
	public PaymentPageTest() {
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
		
		addToCartPage=new AddToCartPage();
		checkoutPage=addToCartPage.clickAddToCart();
		
		checkoutPage=new CheckoutPage();
		paymentPage=checkoutPage.clickCheckout1();
		
		
	}
	

	@Test
	public void makePayment() {
		paymentPage=new PaymentPage();		
		cardDetailsPage=paymentPage.clickPaymentBtn();
	}
}
