package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


public class Updatecontact {

	WebDriver driver;
	public Updatecontact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// locators
	
	@FindBy(linkText="Update Contact Info")
	WebElement lnkUpdateContactInfo;
	
	@FindBy(id="customer.firstName")
	WebElement txtFirstName;
	
	@FindBy(id="customer.lastName")
	WebElement txtLastName;
	
	@FindBy(id="customer.address.street")
	WebElement txtAddress;
	
	@FindBy(id="customer.address.city")
	WebElement txtCity;
	
	@FindBy(id = "customer.address.state")
    WebElement txtState;

    @FindBy(id = "customer.address.zipCode")
    WebElement txtZipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement txtPhone;
    
    @FindBy(xpath="//input[@value='Update Profile']")
    WebElement btnUpdateProfile;
    
    //Action
    
    public void navigateToUpdateContact() {
        lnkUpdateContactInfo.click();
    }

    public void setFirstName(String fname) {
        txtFirstName.clear();
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.clear();
        txtLastName.sendKeys(lname);
    }

    public void setAddress(String address) {
        txtAddress.clear();
        txtAddress.sendKeys(address);
    }

    public void setCity(String city) {
        txtCity.clear();
        txtCity.sendKeys(city);
    }

    public void setState(String state) {
        txtState.clear();
        txtState.sendKeys(state);
    }

    public void setZipCode(String zip) {
        txtZipCode.clear();
        txtZipCode.sendKeys(zip);
    }

    public void setPhone(String phone) {
        txtPhone.clear();
        txtPhone.sendKeys(phone);
    }

    public void clickUpdateProfile() {
        btnUpdateProfile.click();
    }
	
}
