package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class ProductResultsPage extends TestBase{
	
	/*@FindBy(xpath="//div[@class='rush-component']//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'SAMSUNG Galaxy S20 FE 5G Factory Unlocked Android ')]") 
	WebElement resultDisplay;*/
	@FindBy(xpath="//span[contains(text(),'TCL 20 SE 6.82\" Unlocked Cellphone')]")
	WebElement resultDisplay;
	
		
	public ProductResultsPage(){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public AddToCartPage selectproduct() {
		resultDisplay.click();
		return new AddToCartPage();
	}
}
