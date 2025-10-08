package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import java.time.Duration;
import java.util.List;

public class Loginpage {
	// Properties for locating elements
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	
	
	
	@FindBy(xpath="//*[text()='Login']")@CacheLookup
	private WebElement loginHeader;
	
	
	@FindBy(xpath="//*[text()='Username']")@CacheLookup
	private WebElement usernameHeader;
	
	@FindBy(xpath="//*[text()='Password']")@CacheLookup
	private WebElement passwordHeader;
	
	@FindBy(xpath="//*[text()='Forgot your password? ']")@CacheLookup
	private WebElement Forgot;
	
	 @FindBy(xpath = "//div[@class='orangehrm-login-footer-sm']/*")
	 private WebElement loginFooterElements;
	

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	private WebElement uname;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	private WebElement passwd;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	private WebElement submit;

	@FindBy(xpath="//*[@name='firstName']") @CacheLookup
	private WebElement firstname;

	@FindBy(xpath="//*[@name='lastName']") @CacheLookup
	private WebElement lastname;

	

	


	// Constructor method for connecting to step definition classes and runner classes
	public Loginpage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set your timeout here
	}

	// Operational methods to operate and observe elements
	public boolean areAllElementsDisplayed() {
		return uname.isDisplayed() && passwd.isDisplayed() && submit.isDisplayed();
	}
	
	public void validatePresenceOfLoginPageHeader() {
		wait.until(ExpectedConditions.visibilityOf(loginHeader));
	    
	    // Get the text from the login header element
	    String actualHeaderText = loginHeader.getText();
	    
	    // Validate the text
	    Assert.assertEquals("Login", actualHeaderText);
    } 
	
	public void validatePresenceOfUsernameInputHeader()
	{
		wait.until(ExpectedConditions.visibilityOf(usernameHeader)).isDisplayed();
		// Assertion to validate presence
        Assert.assertTrue("Username input field is not present", usernameHeader.isDisplayed());
	}
	
	public void validatePresenceOfpasswordInputHeader()
	{
		wait.until(ExpectedConditions.visibilityOf(usernameHeader)).isDisplayed();
		// Assertion to validate presence
        Assert.assertTrue("password input field is not present", passwordHeader.isDisplayed());
	}
	
	public void validatePresenceOfunameInputField()
	{
		wait.until(ExpectedConditions.visibilityOf(uname)).isDisplayed();
		 Assert.assertTrue("Username input field is not present", uname.isDisplayed());
	}
	public void validatePresenceOfpasswordInputField()
	{
		wait.until(ExpectedConditions.visibilityOf(uname)).isDisplayed();
		 Assert.assertTrue("Username input field is not present", passwd.isDisplayed());
	}
	
	 public void validatePresenceOfForgotPasswordLink() {
		 wait.until(ExpectedConditions.visibilityOf(Forgot)).isDisplayed();
	        Assert.assertTrue("Login Button is not visible",Forgot.isDisplayed());
	    }
	 
	 public void validatePresenceOfFooterElements() {
		 List<WebElement>l=wait.until(ExpectedConditions.visibilityOfAllElements(loginFooterElements));
	        System.out.println("Size of all footer elements: " + l.size());
	    }
	 
	 
	

	public void validcredentials(String username, String password) {
		// Wait until the username field is visible
		wait.until(ExpectedConditions.visibilityOf(uname)).sendKeys(username);

		// Wait until the password field is visible
		wait.until(ExpectedConditions.visibilityOf(passwd)).sendKeys(password);
	}

	public void submit() {
		wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	}
	
	public void userdetails(String first,String last)
	{
		wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(first);
		wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(last);
	}
	
}


