package testCase;

import testBase.BaseClass;
import utils.Testdata;
import org.testng.annotations.Test;
import pageObjects.*;
import org.testng.Assert;



public class TC05_Transferfund extends BaseClass {
	
	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
	public void test_TransferFunds() {
		 logger.info("===== Starting Transfer Funds Test =====");
		 
		 //login
		 
		 Loginpage loginPage = new Loginpage(driver);
		 loginPage.setUsername(Testdata.username);
		 loginPage.setPassword(Testdata.password);
		 loginPage.clickLoginButton();
		 logger.info("Logged in successfully");
		 
		 
		// account from Accounts overview
		 AccountOverview ao = new AccountOverview(driver);
		 int accountcount = ao.getAllAccount().size(); 
		 Assert.assertTrue(accountcount >=2 ,"need 2 account"); 
		 String fromacc = Testdata.account1; 
		 String toacc = Testdata.account2; 
		 logger.info("From Account: " + fromacc + ", To Account: " + toacc);
		 
		 //Transfer
		 
		 Transferfund tf = new Transferfund(driver);
		 tf.clickTransferFundsLink();
		 tf.enterAmount("20");
		 tf.selectFromAccount(fromacc);
		 tf.selectToAccount(toacc);
		 tf.clickTransfer();
		 
		 // message confirm
		 
		 boolean confirmation = tf.isTransferSuccessful();
		 Assert.assertTrue(confirmation, "Transfer not complete");
		 logger.info("Transfer Funds Test Passed ");
		 
		
		
	}

}
