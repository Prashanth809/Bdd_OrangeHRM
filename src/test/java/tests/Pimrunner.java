package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Smoke testing
@CucumberOptions(
		dryRun=false,
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
		tags="@AddEmployee",
		monochrome=true
		)
public class Pimrunner extends AbstractTestNGCucumberTests {

}
