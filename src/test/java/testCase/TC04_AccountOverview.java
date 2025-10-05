package testCase;

import org.testng.annotations.Test;
import pageObjects.AccountOverview;
import pageObjects.OpenNewAccount;
import testBase.BaseClass;
import org.testng.Assert;
import pageObjects.Loginpage;
import utils.Testdata;


public class TC04_AccountOverview extends BaseClass{

	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
	public void test_AccountOverview() {
		
		logger.info(" Starting TC04_AccountOverview");
		
		
		 //  Login first
	    Loginpage loginPage = new Loginpage(driver);
	    loginPage.setUsername(Testdata.username);
	    loginPage.setPassword(Testdata.password);
	    loginPage.clickLoginButton();
	    logger.info("Logged in before accessing Account Overview");
	    
		//Go to account overview
		AccountOverview ao = new AccountOverview(driver);
		
		// account Counts
		int accountcount = ao.getAllAccount().size();
		logger.info("Currently available accounts: " + accountcount);
		
		//if only 1 account , create a new one 
		if(accountcount < 2) {
			 logger.info("Only 1 account found → Creating new account...");
			 
			 OpenNewAccount openAcc = new OpenNewAccount(driver);
			  openAcc.clickOpenNewAccountLink();
	            openAcc.selectAccountType("CHECKING");  // or Savings
	            openAcc.selectFromAccount();
	            openAcc.clickOpenAccount();
	            
	            String newAccNo = openAcc.getNewAccountNumber();
	            logger.info("New account created: " + newAccNo);
	         
	         // Go back to Account Overview
	            ao.clickAccountOverview();
	            accountcount = ao.getAllAccount().size();
	           
		}

		 
		//Verify at least 2 accounts exist
        Assert.assertTrue(accountcount >= 2, " Less than 2 accounts exist!");
      
       
     // Step 5: Get first and second account numbers 
        String acc1 = ao.getFirstAccountNumber(); 
        String acc2 = ao.getSecondAccountNumber(); 
     
        // Store in Testdata for reuse for find transaction
        Testdata.account1 = acc1;
        Testdata.account2 = acc2;
        
        logger.info("Account 1: " + acc1); 
        logger.info("Account 2: " + acc2);
        logger.info("Account Overview test passed"); 
        logger.info("Finished TC_AccountOverview ");
        
     
	}
	
}
