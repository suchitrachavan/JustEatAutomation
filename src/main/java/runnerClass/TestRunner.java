package runnerClass;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Helpers.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =  {"classpath:featureFile"},
        glue=       {"stepDefination"},
        plugin =    {
                    "pretty", "html:target/cucumber-html-report",
                    "json:target/cucumber.json","json:target/cucumber.xml"
                    }
        )

public class TestRunner {
	
	
 
}