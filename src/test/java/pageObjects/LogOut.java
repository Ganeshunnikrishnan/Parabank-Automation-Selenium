package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogOut {
	  WebDriver driver;
	    WebDriverWait wait;

	    public LogOut(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }
	    
	    
	    //Locators
	    
	    @FindBy(linkText = "Log Out")
	    WebElement lnkLogout;
	    
	    
	    // Actions
	    public void clickLogout() {
	        wait.until(ExpectedConditions.elementToBeClickable(lnkLogout)).click();
	    }
	    
	    
	    public boolean isLoggedOut() {
	        try {  
	            return driver.getTitle().contains("ParaBank | Welcome");
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
