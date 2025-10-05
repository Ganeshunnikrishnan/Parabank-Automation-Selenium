package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class BillPay {
WebDriver driver;
Logger logger = LogManager.getLogger(BillPay.class);

public BillPay(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}

// Locators

@FindBy(linkText="Bill Pay")
WebElement linkBillPay;


@FindBy(name="payee.name")
WebElement txtPayeeName;

@FindBy(name="payee.address.street")
WebElement txtAddress;

@FindBy(name="payee.address.city")
WebElement txtCity;

@FindBy(name="payee.address.state")
WebElement txtState;

@FindBy(name="payee.address.zipCode")
WebElement  txtZip;

@FindBy(name="payee.phoneNumber")
WebElement txtPhone;

@FindBy(name="payee.accountNumber")
WebElement txtAccount;

@FindBy(name="verifyAccount")
WebElement txtVerifyAccount;

@FindBy(name="amount")
WebElement txtAmount;

@FindBy(name="fromAccountId")
WebElement selectFromAccount;

@FindBy(xpath = "//input[@value='Send Payment']")
WebElement btnSendPayment;

@FindBy(xpath = "//h1[contains(text(),'Bill Payment Complete')]")
WebElement msgPaymentComplete;

// Actions

public void navigateToBillPay() {
	linkBillPay.click();
	logger.info("Navigated to Bill Pay page");
}


//Fill Payee Name
public void enterPayeeName(String payeeName) {
 txtPayeeName.clear();
 txtPayeeName.sendKeys(payeeName);
 logger.info("Entered Payee Name: " + payeeName);
}

//Fill Address
public void enterAddress(String address) {
 txtAddress.clear();
 txtAddress.sendKeys(address);
 logger.info("Entered Address: " + address);
}

//Fill City
public void enterCity(String city) {
 txtCity.clear();
 txtCity.sendKeys(city);
 logger.info("Entered City: " + city);
}

//Fill State
public void enterState(String state) {
 txtState.clear();
 txtState.sendKeys(state);
 logger.info("Entered State: " + state);
}

//Fill Zip
public void enterZip(String zip) {
 txtZip.clear();
 txtZip.sendKeys(zip);
 logger.info("Entered Zip: " + zip);
}

//Fill Phone
public void enterPhone(String phone) {
 txtPhone.clear();
 txtPhone.sendKeys(phone);
 logger.info("Entered Phone: " + phone);
}

//Fill Account Number
public void enterAccountNumber(String account) {
 txtAccount.clear();
 txtAccount.sendKeys(account);
 logger.info("Entered Account Number: " + account);
}

//Fill Verify Account
public void enterVerifyAccount(String verifyAccount) {
 txtVerifyAccount.clear();
 txtVerifyAccount.sendKeys(verifyAccount);
 logger.info("Entered Verify Account: " + verifyAccount);
}

//Fill Amount
public void enterAmount(String amount) {
 txtAmount.clear();
 txtAmount.sendKeys(amount);
 logger.info("Entered Amount: " + amount);
}

//Select From Account
public void selectFromAccount(String fromAccountValue) {
 Select fromAccountDropdown = new Select(selectFromAccount);
 fromAccountDropdown.selectByVisibleText(fromAccountValue);
 logger.info("Selected From Account: " + fromAccountValue);
 logger.info("Filled Bill Pay form");
}

public void clickSendPayment() {
    btnSendPayment.click();
    logger.info("Clicked Send Payment button");
}

public boolean isPaymentSuccessful() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(msgPaymentComplete));
        logger.info("Bill Payment completed successfully");
        return true;
    } catch (Exception e) {
        logger.error("Bill Payment failed or confirmation message not found");
        return false;
    }
}

}
