package testCase;


import testBase.BaseClass;
import utils.Testdata;
import org.testng.annotations.Test;
import pageObjects.*;
import org.testng.Assert;

public class TC08_Updatecontact extends BaseClass{

	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"})
	public void verifyUpdateContactInfo() {
		logger.info("===== Starting Update Contact Info Test =====");
		
		// Login
		Loginpage loginpage = new Loginpage(driver);
		loginpage.setUsername(Testdata.username);
		loginpage.setPassword(Testdata.password);
		loginpage.clickLoginButton();
		  logger.info("Logged in successfully");
		  
		  //navigate update contact 
		  Updatecontact uc = new Updatecontact(driver);
		  uc.navigateToUpdateContact();
		  logger.info("Navigated to Update Contact Info page");
		  
		  //update fields
		  uc.setFirstName("Ravi");
		  uc.setLastName("G");
		  uc.setAddress("Kuttor");
		  uc.setCity("Thiruvalla");
		  uc.setState("Kerala");
		  uc.setZipCode("689106");
		  uc.setPhone("7306296250");
		  logger.info("Entered new contact info");
		  
		  // Click submit
		  
		  uc.clickUpdateProfile();
		  logger.info("Clicked Update Profile");
		  
		  // Validation → page contains confirmation message
		  String pageSource = driver.getPageSource();
	        Assert.assertTrue(pageSource.contains("Profile Updated"), "Contact Info not updated!");
	        logger.info("Update Contact Info Test Passed");

	        logger.info("===== Update Contact Info Test Completed =====");
	}
}
