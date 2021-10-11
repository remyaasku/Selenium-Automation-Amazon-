package com.amazon.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.AddToCartPage;
import com.amazon.pages.CardDetailsPage;
import com.amazon.pages.CardErrorPage;
import com.amazon.pages.CheckoutPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PasswordPage;
import com.amazon.pages.PaymentPage;
import com.amazon.pages.ProductResultsPage;
import com.amazon.util.TestUtil;

public class CardDetailsPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	PasswordPage passwordPage;
	ProductResultsPage productResultPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	PaymentPage paymentPage;
    CardDetailsPage cardDetailsPage;
    CardErrorPage cardErrorPage;
    TestUtil testUtil;
    
    public CardDetailsPageTest() {
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
		paymentPage=checkoutPage.clickCheckout();
		
        paymentPage=new PaymentPage();		
		cardDetailsPage=paymentPage.clickPaymentBtn();
		
		
	}
    
    @Test(dataProvider="getData")
    public void cardDetailsAdd(String cardnum,String cardname,String value,String year,String cvv,String expected,String xpathActual) {
    	cardDetailsPage =new CardDetailsPage();
    	/*cardDetailsPage.setCardNumber(prop.getProperty("cardnum"));
    	cardDetailsPage.setCardName(prop.getProperty("cardname"));
    	cardDetailsPage.setExpDay(prop.getProperty("value"));
    	cardDetailsPage.setExpYear(prop.getProperty("year"));
    	cardDetailsPage.setCvv(prop.getProperty("cvvvalue"));*/
    	cardDetailsPage.setCardNumber(cardnum);
    	cardDetailsPage.setCardName(cardname);
    	cardDetailsPage.setExpDay(value);
    	cardDetailsPage.setExpYear(year);
    	cardDetailsPage.setCvv(cvv);
    	cardErrorPage=cardDetailsPage.clickAddCard();
    	
    	String actual="";
    	try {
    		actual=driver.findElement(By.xpath(xpathActual)).getText();
    	}
    	catch(Exception e) {
    		
    	}
    	Assert.assertEquals(actual, expected,"Incorrect Message");
    	}
    
    	
    
    
    @DataProvider
    public Object[][] getData() throws IOException{
    	Object[][] data=TestUtil.testData("C:\\Users\\asus\\eclipse-workspace\\AmazonTest\\src\\com\\amazon\\testdata\\AmazonTestData.xlsx","carddetails");
    	return data;
    }
    
 /*   @AfterMethod
    public void tearDown() {
    	driver.quit();
    }*/
    	
    	
    }
	


