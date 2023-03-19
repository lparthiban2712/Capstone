package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", 
glue="stepsDefs",monochrome=true,
plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
