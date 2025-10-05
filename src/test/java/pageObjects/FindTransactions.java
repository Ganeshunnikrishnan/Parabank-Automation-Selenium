package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver ;
import java.util.List;

public class FindTransactions {

	WebDriver driver;
	
	
	public FindTransactions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(linkText="Find Transactions")
	WebElement linkFindTransactions;
	
	@FindBy(id="accountId")
	WebElement dropdownAccount;
	
	@FindBy(id="amount")
	WebElement inputAmount;
	
	@FindBy(id="findByAmount")
	WebElement btnFindByAmount;
	
	@FindBy(xpath = "//table[@id='transactionTable']//tr[2]")
	WebElement firstResultRow;
	
	@FindBy(xpath = "//table[@id='transactionTable']//tr[position()>1]")
    List<WebElement> allTransactionRows;
	
	// Actions
	
	   public void openFindTransactions() {
	        linkFindTransactions.click();
	    }
	   
	   public void selectAccount(String accountNumber) {
	        new Select(dropdownAccount).selectByVisibleText(accountNumber);
	    }
	   
	   public void enterAmount(String amount) {
		    inputAmount.clear();   
		    inputAmount.sendKeys(amount); 
		}
	   
	   public void searchByAmount(String amount) {
	        inputAmount.clear();
	        inputAmount.sendKeys(amount);
	        btnFindByAmount.click();
	    }
	   
	   public boolean isResultDisplayed() {
	        try {
	            return firstResultRow.isDisplayed();
	        } catch(Exception e) {
	            return false;
	        }
	    }

	    public int getTransactionCount() {
	        return allTransactionRows.size();
	    }
}
