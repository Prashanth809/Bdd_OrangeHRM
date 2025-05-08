package gluecode;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Duration;
import pages.Loginpage;
import pages.Pimpage;
import utilities.ActionsUtility;
import utilities.PropertiesFileUtility;
import utilities.WebSiteUtility;

public class PimStepdef 
{
	WebSiteUtility su;
	RemoteWebDriver driver;
	Loginpage lp;
	PropertiesFileUtility pu;
	Pimpage pim;
	Shared sh;
	Scenario se;
	ActionsUtility au;
	
		public PimStepdef(Shared sh) {
			this.sh=sh;
			this.driver=sh.driver;
			this.se=sh.se;
			lp=new Loginpage(driver);
			pim=new Pimpage(driver);
		
	}
	
	@Then("the user should verify the CSS color and background color before action on {string} navbar")
	public void csscolor(String addemploye)
	{
		pim.beforeaction(addemploye);
	}
	@Then("the user mouseover to {string} navigation bar")
	public void mousemove(String addemploye)
	{
		pim.aftermove(addemploye);
	}
	@Then("the user verifies the CSS color and background color of the {string} navigation bar after mouseover")
	public void aftermouseaction(String addemploye)
	{
		pim.afteraction(addemploye);
	}
}
