package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogOut;
import pageObjects.Loginpage;
import testBase.BaseClass;
import utils.*;

public class TC10_LogOut extends BaseClass{
	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
    public void testLogoutAndCloseBrowser() {
		logger.info("===== Starting Logout Test =====");

        // Step 1: Login first (if not already logged in)
        Loginpage login = new Loginpage(driver);
        login.setUsername(Testdata.username);
        login.setPassword(Testdata.password);
        login.clickLoginButton();
        logger.info("Logged in successfully before logout");

        //  Logout
        LogOut logout = new LogOut(driver);
        logout.clickLogout();
        logger.info("Clicked Logout link");
        
        // Verify logout success
        Assert.assertTrue(logout.isLoggedOut(), "Logout failed!");
        logger.info("Logout successful");

       // ExtentReportManager reportManager = new ExtentReportManager();
       // reportManager.captureScreenshot(driver, "Logout_Success");
     // Close all tabs 
        driver.quit();
        logger.info("All browser tabs closed and WebDriver session ended");

        logger.info("===== Logout Test Completed =====");
    
        
	}
}
