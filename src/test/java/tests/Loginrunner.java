package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Smoke testing
@CucumberOptions(
		dryRun=false,
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
		tags="@smoke",
		monochrome=true
		)
public class Loginrunner extends AbstractTestNGCucumberTests 
{
 
}
