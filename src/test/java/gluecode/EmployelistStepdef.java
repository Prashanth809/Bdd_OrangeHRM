package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Loginpage;
import pages.EmployelistPage;

import utilities.ActionsUtility;
import utilities.PropertiesFileUtility;
import utilities.WebSiteUtility;

public class EmployelistStepdef {


	WebSiteUtility su;
	RemoteWebDriver driver;
	Loginpage lp;
	PropertiesFileUtility pu;

	Shared sh;
	Scenario se;
	ActionsUtility au;
	EmployelistPage elp;

	public EmployelistStepdef(Shared sh) {
		this.sh=sh;
		this.driver=sh.driver;
		this.se=sh.se;
		lp=new Loginpage(driver);

		elp=new EmployelistPage(driver);
		pu=new PropertiesFileUtility();
		su=new WebSiteUtility();

	}

	@When("user clicks on PIM")
	public void clickpim()
	{
		elp.clickPIM();

	}
	@Then("user clicks on AddEmployee")
	public void AddEmployee()
	{
		elp.AddEmployee();
	}


	@Then("user enters the {string} and {string}")
	public void user_enters_the_and(String firstname, String lastname) throws Exception {
		elp.flname(firstname, lastname);
		su.captureScreenshot(driver);
	}
	
	
	@Then("user click on save button")
	public void clickSave()
	{
		elp.clicksave();
	}

	@Then("employelist page should be displayed with employee personal details")
	public void my_info_page_should_be_displayed_with_employee_personal_details() {
		elp.allelementsaredisplayed();
		se.log("all elements are displayed");
	}

	@Then("User should see first name, last name")
	public void user_should_see_first_name_last_name() throws Exception {
		String expectedFirstName = pu.getValueInPropertiesFile("firstname");
		String expectedLastName = pu.getValueInPropertiesFile("lastname");

		String expectedFullName = expectedFirstName + " " + expectedLastName;
		String actualFullName = elp.getDisplayedNames();

		se.log("Expected Name: " + expectedFullName);
		se.log("Actual Name: " + actualFullName);

		assert actualFullName.equals(expectedFullName) : "Name mismatch!";
	}

	@Then("user enter the {string}")
	public void licensenumber(String License) throws Exception {
		elp.licensenumber(License);
		su.captureScreenshot(driver);
	}

}
