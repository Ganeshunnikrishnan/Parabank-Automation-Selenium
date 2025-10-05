package testCase;


//import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Testdata;
import pageObjects.Loginpage;
import testBase.BaseClass;



public class TC02_login  extends BaseClass {
	
	@Test(groups = {"smoke", "regression"})
    public void verifyLogin() {
        logger.info("===== Starting Login Test =====");

        // Read registered username and pass word from system properties
       String uname = Testdata.username ;
       String pwd = Testdata.password;

        Loginpage loginPage = new Loginpage(driver);
        
        // Enter username and password
        loginPage.setUsername(uname);
        loginPage.setPassword(pwd);

        // Perform login
        loginPage.clickLoginButton();
        logger.info("Login attempted with username: " + uname);
        logger.info("Login attempted with username: " + pwd);
       
        logger.info("===== Login Test Completed =====");
        
    }

}
