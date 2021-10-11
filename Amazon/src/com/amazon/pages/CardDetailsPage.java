package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.TestBase;

public class CardDetailsPage extends TestBase{
	
	//@FindBy(xpath="//div[@class='a-popover-wrapper']")
	
//	@FindBy(xpath="//div[@id='a-popover-1']")
//	WebElement cardFrame;
	
	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement cardNumber;
	
	@FindBy(xpath="//input[@name='ppw-accountHolderName']")
	WebElement cardName;
	
	@FindBy(xpath="//select[@name='ppw-expirationDate_month']")
	WebElement expDay;
	
	@FindBy(xpath="//select[@name='ppw-expirationDate_year']")
	WebElement expYear;	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement cvv;
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
	WebElement addCard;
	
	public CardDetailsPage() {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void setCardNumber(String cardnum) {
	   driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		cardNumber.sendKeys(cardnum);
	}
	
	public void setCardName(String cardname) {
		cardName.sendKeys(cardname);
	}
	
	public void setExpDay(String value) {
		Select select=new Select(expDay);
		select.selectByValue(value);
	}
	
	public void setExpYear(String year) {
		Select sel=new Select(expYear);
		sel.selectByIndex(7);
	}

	public void setCvv(String cvvvalue) {
		cvv.sendKeys(cvvvalue);
	}
	
	public CardErrorPage clickAddCard() {
		addCard.click();
		return new CardErrorPage();
	}
}

	


