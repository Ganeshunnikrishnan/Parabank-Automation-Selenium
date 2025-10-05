package pageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpenNewAccount {

	
	WebDriver driver;
	 Logger logger = LogManager.getLogger(OpenNewAccount.class);
	
	public OpenNewAccount(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	// Link to navigate to Open New Account page
	@FindBy(xpath="//a[normalize-space()='Open New Account']")
	 WebElement linkOpenNewAccount;
	
	
	// Dropdown for account type
	@FindBy(id="type")
	WebElement accountType;
	
	  // Dropdown for funding account
    @FindBy(id = "fromAccountId")
    WebElement fromAccount;

    
    // Button to open account
    @FindBy(xpath = "//input[@value='Open New Account']")
    WebElement btnOpen;
    
    // Generated account number
    @FindBy(id = "newAccountId")
    WebElement newAccountId;

    
    // Actions

    public void clickOpenNewAccountLink() {
        linkOpenNewAccount.click();
        logger.info("Navigated to 'Open New Account' page");
    }

    public void selectAccountType(String type) {
        new Select(accountType).selectByVisibleText(type);
        logger.info("Selected Account Type: " + type);
    }

    // Select first available account (default)
    public void selectFromAccount() {
        Select select = new Select(fromAccount);
        String firstAcc = select.getOptions().get(0).getText();
        select.selectByIndex(0);
        logger.info("Selected first available funding account: " + firstAcc);
    }

    // Select account by specific number
    public void selectFromAccount(String accountNum) {
        new Select(fromAccount).selectByVisibleText(accountNum);
        logger.info("Selected funding account: " + accountNum);
    }

    public void clickOpenAccount() {
        btnOpen.click();
        logger.info("Clicked 'Open New Account' button");
    }

    public String getNewAccountNumber() {
    	String accNum = newAccountId.getText();
        logger.info("New Account Number generated: " + accNum);
        return accNum;
    }
	
	
	
	
}
