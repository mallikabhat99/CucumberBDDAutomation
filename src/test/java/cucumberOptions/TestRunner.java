package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Feature file 
//Step definition  - identified when cucumber options also has same parent

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",monochrome=true,dryRun=false,strict=true,
glue="stepDefinations",
tags="@MobileTest",
plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml"})
public class TestRunner {

}
