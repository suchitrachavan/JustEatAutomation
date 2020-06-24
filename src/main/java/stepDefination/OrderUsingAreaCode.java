package stepDefination;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Config.ConfigFile;
import Helpers.BaseClass;
import Helpers.CommonFunctions;
import Helpers.CustomExtentReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@SuppressWarnings("unused")
public class OrderUsingAreaCode extends BaseClass {
  
    private static CustomExtentReport customextentreporter;
    private static boolean isreportRunning;
    public boolean ErrorFlag=false;
  
   @Before
   public void beforeScenario()
   {
	   if(!isreportRunning)
	   {
		   customextentreporter = new CustomExtentReport(ConfigFile.outPutDir);
		   isreportRunning=true;
	   }
   }
     
   @After
   public void AfterScenario(Scenario scenario) throws IOException, InterruptedException
   {
	   if(scenario.isFailed())
	   {
		   CommonFunctions.capture(BaseClass.driver);
			Thread.sleep(5000);
			customextentreporter.createTest(scenario, ConfigFile.screenShot);
			customextentreporter.writeToReport();
			 if(BaseClass.driver!=null)
				 
			 {
				 BaseClass.driver.close();
				 BaseClass.driver.quit();
				 
			 }
	   }
	   else
	   {
		 customextentreporter.createTest(scenario, ConfigFile.screenShot);
		 customextentreporter.writeToReport();
		
	   }
	  
	   
   }
   

	@Given("^I want food in \"(.*?)\"$")
	public void i_want_food_in(String arg1) throws Throwable {
		
		LogintoJustEat();
		
		
		if (CommonFunctions.waitForVisiblity(BaseClass.driver.findElement(By.xpath("//input[@name='postcode']")), 120)) {
			BaseClass.driver.findElement(By.xpath("//input[@name='postcode']")).click();
			Thread.sleep(5000);
			BaseClass.driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(arg1);
			Thread.sleep(5000);
			
		}
		
		
	}
 
	@When("^I search for restaurants$")
	public void i_search_for_restaurants() throws Throwable {

		if (CommonFunctions.waitForVisiblity(BaseClass.driver.findElement(By.xpath("//span[text()='Search']")), 120)) {
			BaseClass.driver.findElement(By.xpath("//span[text()='Search']")).click();
			Thread.sleep(5000);
		}
		  
		
	}

	@Then("^I should see some restaurants in \"(.*?)\"$")
	public void i_should_see_some_restaurants_in(String arg1) throws Throwable {

		

		if (CommonFunctions.waitForVisiblity(BaseClass.driver.findElement(By.xpath("//div[@data-test-id='openrestaurants']//a//h3")), 120)) {
			List<WebElement> allLinks = driver.findElements(By.xpath("//div[@data-test-id='openrestaurants']//a//h3"));
			 for ( WebElement i: allLinks) { 
			     String name=i.getText();
				 System.out.println("Name of the opeen Restaurant is:"+name);
			    }
			  
			
		}
	
	}
	 @After public void cleanUp(){ 
		 BaseClass.driver.close();
		 BaseClass.driver.quit();
	   } 
   

}
