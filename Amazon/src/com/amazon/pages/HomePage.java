package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class HomePage extends TestBase {
	
	//PageFactory or the Object repo
	
	 @FindBy(xpath="//a[@id='nav-link-accountList']") 
	 WebElement hoverelement;	
	 
	 
	 @FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']") 
		WebElement signInBtn;
		
		
		@FindBy(id="nav-logo-sprites")
		WebElement amazonlogo;
		
		@FindBy(xpath="//span[@class='icp-nav-flag icp-nav-flag-us']")
		WebElement languageselect;
		
		
		//initializing the page objects
		public HomePage() {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		//actions:
		public String validatePageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateLogo() {
			return amazonlogo.isDisplayed();
		}

		public void hovermouse() {
			 Actions action=new Actions(driver);
			 action.moveToElement(hoverelement).perform();
		 }
		
		/*public void hovermouselanguage() {
			 Actions action=new Actions(driver);
			 action.moveToElement(languageselect).perform();
		}*/
		@FindBy(xpath="//span[normalize-space()='Account & Lists']//span[@class='nav-icon nav-arrow']") 
		WebElement drpdownClick;
		
		/*public LoginPage clickSignin() {
			signInBtn.click();
			return new LoginPage();
		}*/
		
		@FindBy(xpath="//input[@id='twotabsearchtextbox']") 
		WebElement productsearchbox;
		
		@FindBy(xpath="//input[@id='nav-search-submit-button']") 
		WebElement searchbutton;
		
		public LoginPage clickdrpDown() {
			drpdownClick.click();
			return new LoginPage();
		}
		
		public ProductResultsPage settxtSearch(String product) {
			productsearchbox.sendKeys(product);
			searchbutton.click();
			return new ProductResultsPage();
		}
}
