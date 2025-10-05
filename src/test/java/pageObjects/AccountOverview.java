package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class AccountOverview {
	WebDriver driver;
	
	public AccountOverview( WebDriver driver ) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Naviage to accountoverview
	@FindBy(linkText="Accounts Overview")
	WebElement lnkAccountOverview;
	
	 //  Table of accounts
	@FindBy(xpath="//table[@id='accountTable']//a")
	List<WebElement> accountLinks;
	
	//Action
	
	// navgate accountoverview
	 public void clickAccountOverview() {
		 lnkAccountOverview.click();
	 }
	
	//firstrow
	
	public String getFirstAccountNumber() {
		if(accountLinks.size() > 0) {
			return accountLinks.get(0).getText();
		}else {
			return null;
		}
	}
      
	// second row
	
	public String getSecondAccountNumber() {
		if(accountLinks.size() > 1) {
			return accountLinks.get(1).getText();
		}else {
			return null;
	}
	
	}
	
	// all rows display 
	public List<WebElement> getAllAccount(){
		return accountLinks;
	}
	
	
	
	
	
}
