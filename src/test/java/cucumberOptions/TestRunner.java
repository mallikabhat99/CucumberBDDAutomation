package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Feature file 
//Step definition  - identified when cucumber options also has same parent

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",monochrome=true,dryRun=false,
glue={"stepDefinations"}, tags = "@DeletePlace" , plugin ="json:target/jsonReports/cucumber-report.json")
public class TestRunner {

}
