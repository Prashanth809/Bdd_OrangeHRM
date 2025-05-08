package gluecode;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Loginpage;
import pages.Pimpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import utilities.PropertiesFileUtility;
import utilities.WebSiteUtility;

public class LoginStepdef {
	WebSiteUtility su;
	RemoteWebDriver driver;
	Loginpage lp;
	PropertiesFileUtility pu;
	Pimpage pim;
	Shared sh;
	Scenario se;
	public LoginStepdef(Shared sh)
	{
		this.sh=sh;
		this.se=sh.se;
	}

	@Given("i open {string} browser")
	public void method1(String browserName) throws Exception {
		su=new WebSiteUtility();
		sh.driver=su.openBrowser(browserName); //important to create shared driver
		this.driver=sh.driver; //important to assign shared driver to local driver 

		lp = new Loginpage(driver);
		pim=new Pimpage(driver);
	}
	
	

	@Given("user launch site")
	public void launchSite() throws Exception {
		// Launch the site using the driver
		
		su.launchSite(sh.driver);
//		if (driver != null) {
//			su.launchSite(driver);
//		} else {
//			throw new Exception("Driver is not initialized.");
//		}
	}
	@Then("I should see the Login Header in the Login Page")
	public void i_should_see_the_login_header_in_the_login_page() {
		lp.validatePresenceOfLoginPageHeader();
        
    }
	@Then("I should see the Username and Password Headers")
	 public void i_should_see_the_username_and_password_headers() {
        lp.validatePresenceOfUsernameInputHeader();
        lp.validatePresenceOfpasswordInputHeader();
    }

    @Then("I should see the Username and Password fields")
    public void i_should_see_the_username_and_password_fields() {
        lp.validatePresenceOfunameInputField();;
        lp.validatePresenceOfpasswordInputField();
    }

    @Then("I should see the Forgot Password Link and all the footer elements")
    public void i_should_see_the_forgot_password_link_and_all_the_footer_elements() {
        lp.validatePresenceOfForgotPasswordLink();
        lp.validatePresenceOfFooterElements();
    }

    @Then("I should see the Login button")
    public void i_should_see_the_Login_button() {
        lp.submit();
        //su.closeSite(driver);
    }
	
   @Then("close site")
   public void close()
   {
	   su.closeSite(driver);
   }
	
	
	@Then("user enters the validcredentials")
	public void credentials() throws Exception
	{
		String username = PropertiesFileUtility.getValueInPropertiesFile("username");
		String password = PropertiesFileUtility.getValueInPropertiesFile("password");

		// Use the username and password to fill in the credentials
		lp.validcredentials(username, password);

	}
	@And("user cliks on submit button")
	public void click()
	{
		lp.submit();
	}
	@When("user clicks on PIM")
	public void clickpim()
	{
		lp.clickPIM();

	}
	@Then("user clicks on AddEmployee")
	public void AddEmployee()
	{
		lp.AddEmployee();
	}
	@Then("user enters the {string} and {string}")
	public void userddetials(String firstname, String lastname)
	{
		lp.userdetails(firstname, lastname);
	}
	@Then("user click on save button")
	public void clickSave()
	{
		lp.clicksave();
	}
	@When("user selects 'India' from the nationality dropdown")
	public void selectnationality(String india)
	{
		lp.nationality(india);
	}
	@Then("user selects Unmarried from the marital status dropdown")
	public void selectmarritalstatus(int x)
	{
		lp.marrital(x);
	}
	@When("I check if the radio button is visible and enabled")
	public void radio_button_visible() throws Exception
	{
		lp.testRadioButton();
	}
	@And("I select the radio button")
	public void select_radio()
	{
		lp.gender_radio();
	}
	@When("I should see that the radio button is selected")
	public void gender() throws Exception
	{
		lp.gender_select();
	}
}
