package testCase;

import testBase.BaseClass;
import utils.Testdata;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FindTransactions;
import pageObjects.Loginpage;



public class TC07_FindTransactions extends BaseClass {
 
    @Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
    public void verifyFindTransaction() {
    	logger.info("===== Starting Find Transactions Test =====");

        // Step 1: Login
        Loginpage loginPage = new Loginpage(driver);
        loginPage.setUsername(Testdata.username);
        loginPage.setPassword(Testdata.password);
        loginPage.clickLoginButton();
        logger.info("Logged in successfully");

        
        
        // Step 2: Navigate to Find Transactions page
        FindTransactions ft = new FindTransactions(driver);
        ft.openFindTransactions();
        logger.info("Navigated to Find Transactions page");
        
     // Step 3: Select account dynamically
        String accountNumber = Testdata.account1; 
        ft.selectAccount(accountNumber);
        logger.info("Selected account: " + accountNumber);
        
        String amount = "20"; 
        ft.searchByAmount(amount);
        logger.info("Searched transaction by amount: " + amount);
        
        // Step 5: Verify results
        Assert.assertTrue(ft.isResultDisplayed(), " Transaction not found in Find Transactions!");
        logger.info(" Transaction found successfully");

        
        int transactionCount = ft.getTransactionCount();
        logger.info("Number of transactions found: " + transactionCount);

        
        logger.info("===== Find Transactions Test Completed =====");
        
    }
}
