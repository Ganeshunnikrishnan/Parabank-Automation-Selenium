package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.OpenNewAccount;
import testBase.BaseClass;
import utils.Testdata;
import pageObjects.Loginpage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.*;

public class TC03_OpenNewAccount extends BaseClass{
	
	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
	 public void openNewAccount()  {
		 logger.info("===== Starting Open New Account Test =====");
		
		// Perform login first
		    Loginpage loginPage = new Loginpage(driver);
		    loginPage.setUsername(Testdata.username);
		    loginPage.setPassword(Testdata.password);
		    loginPage.clickLoginButton();
		    logger.info("Logged in before opening new account");
		 
		 
		 OpenNewAccount openAcc = new OpenNewAccount(driver);
		 
		 // Navigate to Open New Account page
	        openAcc.clickOpenNewAccountLink();
	        logger.info("Navigated to Open New Account page");

	        
	        
		 // Select account type (CHECKING)
	        openAcc.selectAccountType("CHECKING");
	        logger.info("Selected account type: CHECKING");
	        
	        // Select the first available funding account automatically
	        openAcc.selectFromAccount();
	        logger.info(" ");

	        // Click Open New Account
	        openAcc.clickOpenAccount();
	        logger.info("Clicked Open New Account button");


	        // Wait until new account number is visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId")));
	        
	    
	        
	     // Store the new account as account2 if account1 already exists
	        String newAccNum = openAcc.getNewAccountNumber();
	        Assert.assertTrue(newAccNum != null && !newAccNum.isEmpty(), "New Account Number should be generated"); 
	        
	        
	        if (Testdata.account1 == null) {
	            Testdata.account1 = newAccNum; // first account
	        } else {
	            Testdata.account2 = newAccNum; // second account
	        }
	        logger.info("Stored account in Testdata: account1=" + Testdata.account1 + ", account2=" + Testdata.account2);
	        
	        
	        logger.info("===== Open New Account Test Finished Successfully =====");
	}

	
}
