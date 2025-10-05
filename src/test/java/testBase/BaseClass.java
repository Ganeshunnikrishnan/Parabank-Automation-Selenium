package testBase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BaseClass {

	protected WebDriver driver; 
	protected Logger logger;
    
	public WebDriver getDriver() {
        return driver;
	}
        @BeforeMethod
        public void setup() {
        	logger = LogManager.getLogger(this.getClass()); 
        	// Message 
        	driver = new ChromeDriver(); // Open Chrome
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	driver.manage().window().maximize();
        	// Maximize the window size 
        	driver.get("https://parabank.parasoft.com/parabank/index.htm"); 
        	// Open the url 
        	logger.info("Browser launched and Parabank site opened"); // Message }
        }
	@AfterMethod
	public void teardown() {
		if (driver != null) {
		//	driver.quit();
		}
	}
}

