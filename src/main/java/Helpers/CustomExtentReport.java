package Helpers;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.cucumber.java.Scenario;

@SuppressWarnings("deprecation")
public class CustomExtentReport {

	
	private ExtentHtmlReporter extentHTMLReporter;
	private ExtentReports extentreports;
	public static  ExtentTest test;
	public static  ExtentTest logger;
	
	
	public CustomExtentReport(String reportLocation) {
		extentHTMLReporter = new ExtentHtmlReporter(new File(reportLocation));
		extentreports = new ExtentReports();
		extentreports.attachReporter(extentHTMLReporter);
	}

	
	
	public void createTest(Scenario scenario, String screenshot) throws IOException
	{
		
		if(scenario!=null)
		{
			String testName=getScenarioTitle(scenario);
			switch(scenario.getStatus())
			{
			case PASSED:
				extentreports.createTest(testName).pass("Passed");
				break;
			case FAILED:
				extentreports.createTest(testName).pass("Failed").addScreenCaptureFromPath(screenshot);	
				break;		
			default:
				extentreports.createTest(testName).pass("Skipped");
				break;
			}
		}
	}
	public void writeToReport()
	{
		
		if(extentreports!=null)
		{
			extentreports.flush();
		}
	}
	private String getScenarioTitle(Scenario scenario)
	{
		return scenario.getName().replaceAll(" ", " ");
		
	}
}
