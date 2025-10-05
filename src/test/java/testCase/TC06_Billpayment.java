package testCase;

import testBase.BaseClass;
import utils.Testdata;
import org.testng.annotations.Test;
import pageObjects.*;
import org.testng.Assert;



public class TC06_Billpayment extends BaseClass {
	
	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
	public void test_BillPayment() {
		 logger.info("===== Starting Bill Payment Test =====");

	        // Login
	        Loginpage loginPage = new Loginpage(driver);
	        loginPage.setUsername(Testdata.username);
	        loginPage.setPassword(Testdata.password);
	        loginPage.clickLoginButton();
	        logger.info("Logged in successfully");
	        
	        
	     // Select "From Account" 
	        AccountOverview ao = new AccountOverview(driver); 
	        String fromAccount = ao.getFirstAccountNumber();
	        logger.info("Pay from Account: " + fromAccount);
	        

	        // Navigate & fill Bill Pay form using individual methods
	        BillPay bp = new BillPay(driver);
	        bp.navigateToBillPay();
	        bp.enterPayeeName("Ganesh U");
	        bp.enterAddress("123 Street");
	        bp.enterCity("CityName");
	        bp.enterState("StateName");
	        bp.enterZip("123456");
	        bp.enterPhone("8547505599");
	        bp.enterAccountNumber("12345");
	        bp.enterVerifyAccount("12345");
	        bp.enterAmount("50");
	        bp.selectFromAccount(fromAccount);
	        
	        
	     // Send Payment
	        bp.clickSendPayment();
	        
	        // Verify
	        boolean status = bp.isPaymentSuccessful();
	        Assert.assertTrue(status, "Bill Payment failed!");
	        logger.info("Bill Payment Test Passed");
	}
	 
   

}
