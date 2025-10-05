package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import testBase.BaseClass;
import utils.Testdata;

public class TC09_requestloan  extends BaseClass {
	
	 @Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
	 public void test_RequestLoan() {
	        logger.info("===== Starting Request Loan Test =====");
	        
	     // Login 
	        Loginpage login = new Loginpage(driver);
	        login.setUsername(Testdata.username);
	        login.setPassword(Testdata.password);
	        login.clickLoginButton();
	        logger.info("Logged in successfully");

   // Available Account
	    //    AccountOverview ao = new AccountOverview(driver);
	     //   int accountCount = ao.getAllAccount().size();

	     //   if (accountCount == 0) {
	    //        Assert.fail("No accounts available for loan request!");
	    //    }
	     //   String fromAccount = ao.getFirstAccountNumber();
	     //   logger.info("Using Account for Loan Request: " + fromAccount);
	        
	        
	        //  Ensure we have accounts
	        if (Testdata.account1 == null) {
	            Assert.fail("No accounts available in Testdata for loan request!");
	        }
	        
	        
	        // request loan 
	        RequestLoan loan = new RequestLoan(driver);
	        loan.clickRequestLoanLink();
	        logger.info("Navigated to Request Loan Page");

	        
	        loan.enterLoanAmount("30");
	        loan.enterDownPayment("2");
	     //   loan.selectFromAccount(fromAccount);
	        
	        // Use first available account from Testdata
	        loan.selectFromAccount(Testdata.account1);
	        logger.info("Selected Account for Loan Request: " + Testdata.account1);
	        
	        
	        loan.clickApplyNow();
	        logger.info("Loan Request Submitted");
	        
	        
	        //status
	        
	        String status = loan.getLoanStatus();
	        logger.info("Loan Status: " + status);

	        Assert.assertTrue(status.equalsIgnoreCase("Approved") || status.equalsIgnoreCase("Denied"),"Unexpected Loan Status!");

	        if (status.equalsIgnoreCase("Approved")) {
	            String accNo = loan.getGeneratedLoanAccount();
	            Assert.assertNotNull(accNo, "Loan approved, but no account was generated!");
	            logger.info("Loan Approved → New Account: " + accNo);
	        } else {
	            logger.info("Loan Denied → No account generated");
	        }

	        logger.info("===== Request Loan Test Completed =====");
	        
}
}