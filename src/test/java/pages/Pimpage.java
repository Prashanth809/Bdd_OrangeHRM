package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pimpage 
{
	// Properties for locating elements
	private RemoteWebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath="//span[text()='PIM']") @CacheLookup
	private WebElement pim1;
	
	@FindBy(xpath="//*[text()='Add Employee']") @CacheLookup
	private WebElement AddEmploye;


	// Constructor method for connecting to step definition classes and runner classes
	public Pimpage(RemoteWebDriver driver)
	{

		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set your timeout here
	}

	//Operational methods to operate and observe elements
	public void beforeaction(String addemploye)
	{
		String x1=wait.until(ExpectedConditions.visibilityOf(pim1)).getCssValue("color");
      System.out.println(x1);
      String x2=wait.until(ExpectedConditions.visibilityOf(pim1)).getCssValue("text-decoration");
      System.out.println(x2);
      
	}
	
	public void aftermove(String addemploye)
	{
		WebElement e=wait.until(ExpectedConditions.visibilityOf(AddEmploye));
		Actions act=new Actions(driver);
		act.moveToElement(e).perform();
		   
	}
	public void afteraction(String addemploye)
	{
		String x3=wait.until(ExpectedConditions.visibilityOf(pim1)).getCssValue("scrollbar-width");
      System.out.println(x3);
      String x4=wait.until(ExpectedConditions.visibilityOf(pim1)).getCssValue("text-decoration");
      System.out.println(x4);
      
	}
}

