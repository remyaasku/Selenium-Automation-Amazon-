package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class CheckoutPage extends TestBase{

	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	WebElement checkoutBtn1;
/*	@FindBy(xpath="//a[@id='hlb-ptc-btn-native']")
	WebElement checkoutBtn2;*/
	
	@FindBy(xpath="//*[contains(text(),'Proceed to checkout')]")
	WebElement checkoutbtn;
//	@FindBy(xpath="//span[@id='sc-buy-box-ptc-button']")
//	@FindBy(xpath="//h4[contains(text(),"Enter how you'd like to pay below, and we'll save ")]") 
	
	@FindBy(xpath="//div[@class='a-alert-content']//h4")
	WebElement xpathActual;
	
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public String verifyPaymentText() {
		return xpathActual.getText();
	}
	
	public PaymentPage clickCheckout1() {
		checkoutBtn1.click();
		return new PaymentPage();
	}
	/*public PaymentPage clickCheckout2() {
		checkoutBtn2.click();
		return new PaymentPage();
	}*/
	
	public PaymentPage clickCheckout() {
		/*if(checkoutBtn1.isDisplayed()) {
			checkoutBtn1.click();
			}
		else  if(checkoutBtn2.isDisplayed()){
			checkoutBtn2.click();			
			}	*/
		checkoutbtn.click();
		return new PaymentPage();
		
	}
	
	
}
