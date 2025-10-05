package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RequestLoan {
	WebDriver driver;
	WebDriverWait wait ;
	
	public RequestLoan(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	
	// locators
	// Navigate requestLoan 
	
	@FindBy(linkText="Request Loan")
	WebElement lnkRequestLoan;
	
	//Loan Amount
	@FindBy(id="amount")
	WebElement txtLoanAmount;
	
	
	@FindBy(id="downPayment")
	WebElement txtDownPayment;
	
	@FindBy(id="fromAccountId")
	WebElement dropdownFromAccount;
	
	@FindBy(xpath="//input[@value='Apply Now']")
	WebElement  btnApplyNow;
	
	//Status label
	@FindBy(id="loanStatus")
	WebElement lblLoanStatus;
	
	@FindBy(id="newAccountId")
	WebElement lblNewAccountId;
	
	//Actions
	
	public void clickRequestLoanLink() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkRequestLoan)).click();
	}
	
	
	 public void enterLoanAmount(String amount) {
		 wait.until(ExpectedConditions.visibilityOf(txtLoanAmount)).clear();
	        txtLoanAmount.sendKeys(amount);
	    }

	    public void enterDownPayment(String amount) {
	    	 wait.until(ExpectedConditions.visibilityOf(txtDownPayment)).clear();
	         txtDownPayment.sendKeys(amount);
	    }
	    
	    
	    public void selectFromAccount(String accountId) {
	        wait.until(ExpectedConditions.visibilityOf(dropdownFromAccount));
	        Select select = new Select(dropdownFromAccount);
	        select.selectByVisibleText(accountId);
	    }

	    
	    public void clickApplyNow() {
	    	wait.until(ExpectedConditions.elementToBeClickable(btnApplyNow)).click();
	    }

	    public String getLoanStatus() {
	    	return wait.until(ExpectedConditions.visibilityOf(lblLoanStatus)).getText();
	    }
	    
	    public String getGeneratedLoanAccount() {
	        try {
	        	return wait.until(ExpectedConditions.visibilityOf(lblNewAccountId)).getText();
	        } catch (Exception e) {
	            return null;
	        }
	    }
	
	
}


