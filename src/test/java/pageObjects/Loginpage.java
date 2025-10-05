package pageObjects;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	
	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);  // initialize @FindBy elements
	}
	
	// Locators using @FindBy
	
	@FindBy(name="username")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement btnLogin;
	
	  // Actions
	
    public void setUsername(String uname) {
        txtUsername.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }
	
	
}
