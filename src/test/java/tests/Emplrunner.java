package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Smoke testing
@CucumberOptions(
		dryRun=false,
		features={"src\\test\\resources\\features\\employelist.feature"},
		glue={"gluecode"},
		tags="",
		monochrome=true,
				 plugin = {
				            "pretty",
				            "html:target/cucumber-reports.html",
				            "json:target/cucumber.json",
				            "testng:target/testng.xml",
				            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				        }
		)

public class Emplrunner extends AbstractTestNGCucumberTests {

}
