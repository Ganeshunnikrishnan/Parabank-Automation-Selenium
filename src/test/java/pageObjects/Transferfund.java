package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class Transferfund {

	WebDriver driver;
	Logger logger =LogManager.getLogger(Transferfund.class);
	
	public Transferfund(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Locators
	
	@FindBy(linkText="Transfer Funds")
	WebElement linkTransferFunds;
	
	@FindBy(id="amount")
	WebElement  txtAmount;
	
	@FindBy(id="fromAccountId")
	WebElement fromAccount;
	
	@FindBy(id="toAccountId")
	WebElement  toAccount;
	
	@FindBy(xpath="//input[@value='Transfer']")
	WebElement btnTransfer;;
	
	@FindBy(xpath="//h1[contains(text(),'Transfer Complete!')]")
	WebElement msgTransferComplete;
	
	
	
	//actions
	
	public void clickTransferFundsLink() {
		linkTransferFunds.click();
		 logger.info("Navigated to Transfer Funds page");
	}
		 public void enterAmount(String amount) {
			 txtAmount.clear();
			 txtAmount.sendKeys(amount);
			 logger.info("Entered transfer amount: " + amount);
		 }
		 
		 
		 public void selectFromAccount(String acc) {
			 new Select(fromAccount).selectByVisibleText(acc);
			 logger.info("Selected From Account: " + acc);
		 }
			 
		 public void selectToAccount(String acc) {
			 new Select(toAccount).selectByVisibleText(acc);
			 logger.info("Selected To Account: " + acc);
		 }
			 
		 public void clickTransfer() {
			 btnTransfer.click();
			 logger.info("Clicked Transfer button");

		 }
	
	public boolean isTransferSuccessful() {
		 try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            wait.until(ExpectedConditions.visibilityOf(msgTransferComplete));
	            logger.info("Transfer success message displayed: true");
	            return true;
	        } catch (Exception e) {
	            logger.error("Transfer success message not found");
	            return false;
	        }
	}
	
	
}
