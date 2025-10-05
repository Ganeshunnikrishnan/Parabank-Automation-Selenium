package testCase;


import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Registerpage;
import testBase.BaseClass;
import utils.Testdata;

public class TC01_Register extends  BaseClass{
	
	 // Utility: Generate random string
	
	private String getRandomString(int length) {
         String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
         StringBuilder sb = new StringBuilder();
         Random rnd = new Random();
         while (sb.length() < length) {
        	 int index = rnd.nextInt(chars.length());
        	 sb.append(chars.charAt(index));
         }
         return sb.toString();
	}
	
	// Utility: Generate random number string
	private String getRandomNumber(int length) {
		String digits = "0123456789";
		 StringBuilder sb = new StringBuilder();
         Random rnd = new Random();
         while (sb.length() < length) {
        	 int index = rnd.nextInt(digits.length());
             sb.append(digits.charAt(index)); 
         }
         return sb.toString();
	}
	
	@Test(groups = {"smoke", "regression"}) 
	public void verifyuserRegistration() {
		 logger.info("===== Starting Registration Test =====");
      Registerpage reg = new Registerpage(driver);
      
   // Click Register link
      reg.clickRegisterLink();
      logger.info("Clicked Register link");
      
   // Generate random user data
      String fname = getRandomString(5);
      String lname = getRandomString(6);
      String address = "123 Main Street";
      String city = "Thiruvalla";
      String state = "KL";
      String zip = getRandomNumber(6);
      String phone = getRandomNumber(10);
      String ssn = getRandomNumber(5);
      String uname = "user" + System.currentTimeMillis();
      String pwd = "Test@123";
      
   // Fill registration form
      reg.setFirstName(fname);
      reg.setLastName(lname);
      reg.setAddress(address);
      reg.setCity(city);
      reg.setState(state);
      reg.setZipCode(zip);
      reg.setPhone(phone);
       reg.setSSN(ssn);
       reg.setUsername(uname);
       reg.setPassword(pwd);
       reg.setConfirmPassword(pwd);
       logger.info("Filled registration form with username: " + uname);
	
       // Click Register
       reg.clickRegisterButton();
       logger.info("Clicked Register button");
       
       // Assertion: Verify registration success
       String pageSource = driver.getPageSource();
       Assert.assertTrue(pageSource.contains("Welcome"), "Registration Failed!");
       logger.info("Registration successful, Welcome message found");
	
    // Store username & password for login test
       Testdata.username = uname;
       Testdata.password = pwd;
       
       logger.info("===== Registration Test Completed =====");
       
	}
	
}


