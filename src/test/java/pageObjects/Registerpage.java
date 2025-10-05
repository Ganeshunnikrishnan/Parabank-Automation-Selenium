package pageObjects;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


public class Registerpage {

	WebDriver driver;
	
	
	public Registerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);  // initializes all @FindBy elements
	}
	
	// Locators find by using @FindBy
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	
	@FindBy(id="customer.firstName")
	WebElement txtFirstName;
	
	@FindBy(id="customer.lastName")
	WebElement txtLastName;
	
	@FindBy(id="customer.address.street")
	WebElement txtAddress;
	
	@FindBy(id="customer.address.city")
	WebElement txtCity;
	
	@FindBy(id="customer.address.state")
	WebElement txtState;
	
	@FindBy(id="customer.address.zipCode")
	WebElement txtZipCode;
	
	@FindBy(id="customer.phoneNumber")
	WebElement txtPhone;
	
	@FindBy(id="customer.ssn")
	WebElement txtSSN;
	
	@FindBy(id="customer.username")
	WebElement txtUsername;
	
	@FindBy(id="customer.password")
	WebElement txtPassword;
	
	@FindBy(id="repeatedPassword")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//input[@value='Register']")
	WebElement btnRegister;
	
	
	// Actions 
	
	public void clickRegisterLink()  {
		linkRegister.click();
	}
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setAddress(String address) {
        txtAddress.sendKeys(address);
    }
	
	 public void setCity(String city) {
	        txtCity.sendKeys(city);
	    }

	    public void setState(String state) {
	        txtState.sendKeys(state);
	    }

	    public void setZipCode(String zip) {
	        txtZipCode.sendKeys(zip);
	    }

	    public void setPhone(String phone) {
	        txtPhone.sendKeys(phone);
	    }

	    public void setSSN(String ssn) {
	        txtSSN.sendKeys(ssn);
	    }

	    public void setUsername(String uname) {
	        txtUsername.sendKeys(uname);
	    }

	    public void setPassword(String pwd) {
	        txtPassword.sendKeys(pwd);
	    }

	    public void setConfirmPassword(String cpwd) {
	        txtConfirmPassword.sendKeys(cpwd);
	    }

	    public void clickRegisterButton() {
	        btnRegister.click();
	    }
	
	
}
