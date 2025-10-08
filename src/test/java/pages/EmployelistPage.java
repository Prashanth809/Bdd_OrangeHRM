package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployelistPage 
{
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(xpath="//span[text()='PIM']") @CacheLookup
	private WebElement pim;
	
	@FindBy(xpath="//*[text()='Add Employee']") @CacheLookup
	private WebElement AddEmploye;
	
	//firstname field
	@FindBy(name="firstName")@CacheLookup 
	private WebElement fn;
	//middlename field
	@FindBy(name="middleName")@CacheLookup 
	private WebElement mn;

	//lastname field
	@FindBy(name="lastName")@CacheLookup 
	private WebElement ln;

	//employeeid field
	@FindBy(xpath="//*[@class='oxd-input oxd-input--active']")@CacheLookup
	private WebElement empid;


	@FindBy(xpath = "//*[text()=\"Driver's License Number\"]/following::div[1]/input") @CacheLookup
	private WebElement driverlicesne;

	@FindBy(xpath="//*[@class='oxd-date-wrapper']/child::div/input[1]")@CacheLookup
	private WebElement licenseexpirydate;



	@FindBy(xpath="//*[text()='Nationality']/following::div[2]")@CacheLookup
	private WebElement nationality;



	@FindBy(xpath="//*[text()='Married']/parent::div")@CacheLookup
	private WebElement marritalstatus;




	@FindBy(xpath="//*[text()='Date of Birth']/following::div[3]")@CacheLookup
	private WebElement DOB;



	@FindBy(xpath="(//input[@type='radio'])[1]")@CacheLookup
	private WebElement gm;

	@FindBy(xpath="(//input[@type='radio'])[2]")@CacheLookup
	private WebElement gf;
	
	
	@FindBy(xpath="//button[@type='submit']")@CacheLookup
	private WebElement savebutton;
	
	@FindBy(xpath="//*[@type='submit']") @CacheLookup
	private WebElement save;





	// Constructor method for connecting to step definition classes and runner classes
	public EmployelistPage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set your timeout here
	}
    
	
		public void clickPIM()
		{
			wait.until(ExpectedConditions.elementToBeClickable(pim)).click();
			
		}
		public void AddEmployee()
		{
			wait.until(ExpectedConditions.elementToBeClickable(AddEmploye)).click();
		}
		public void clicksave()
		{
			wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		}
	
		public void flname(String f, String l)
		{
			wait.until(ExpectedConditions.visibilityOf(fn)).sendKeys(f);
			wait.until(ExpectedConditions.visibilityOf(ln)).sendKeys(l);
			
		}
		
	public boolean allelementsaredisplayed()
	{
		if(fn.isDisplayed()&&mn.isDisplayed()&&ln.isDisplayed()&&empid.isDisplayed()
				&&savebutton.isDisplayed()) 
		{
			return(true);	
		}
		else {
			return(false);
		}
	}
	
	public String getDisplayedNames() {
	    wait.until(ExpectedConditions.visibilityOf(fn));
	    wait.until(ExpectedConditions.visibilityOf(ln));
	    
	    String firstName = fn.getAttribute("value");
	    String lastName = ln.getAttribute("value");

	    return firstName + " " + lastName;
	}
	public void licensenumber(String lnumber) {
	    wait.until(ExpectedConditions.elementToBeClickable(driverlicesne)).click();
	    driverlicesne.clear();
	    driverlicesne.sendKeys(lnumber);
	    
	    // Wait to verify value is retained
	    new WebDriverWait(driver, Duration.ofSeconds(2))
	        .until(ExpectedConditions.attributeToBe(driverlicesne, "value", lnumber));

	    System.out.println("Entered License Number: " + lnumber);
	}






}
