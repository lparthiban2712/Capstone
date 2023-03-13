package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@Registration or @Functional",
features="src/test/java/features", 
glue="stepsDefs",monochrome=true,
plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
