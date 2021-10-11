package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class AddToCartPage extends TestBase{
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addtocart;
	
	public AddToCartPage() {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public CheckoutPage clickAddToCart() {
		addtocart.click();
		return new CheckoutPage();
	}

}
