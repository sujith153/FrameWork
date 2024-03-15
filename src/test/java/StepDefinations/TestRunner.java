package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/authentication.feature",
		glue = "StepDefinations", 
		plugin = {
		"pretty", "junit:target/JUnitReports/report.xml", 
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports/report.html" },
		tags = "@login"
		)
public class TestRunner {

}
