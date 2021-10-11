package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.TestBase;

public class PaymentPage extends TestBase{
	
	@FindBy(xpath="//h4[contains(text(),'Enter how you'd like to pay below, and we'll save ')]")
	WebElement pageMessage;
	
//	@FindBy(xpath="//span[@id='pp-RxJBfY-68']//input[@type='submit']")
//	@FindBy(xpath="//span[contains(text(),'Add a credit or debit card')]")
	@FindBy(xpath="//span[@id='apx-add-credit-card-action-test-id']")
	WebElement selectPaymentBtn;
	
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public CardDetailsPage clickPaymentBtn() {
		selectPaymentBtn.click();
		return new CardDetailsPage();
	}
	
}