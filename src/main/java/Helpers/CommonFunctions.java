package Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Config.ConfigFile;

import org.openqa.selenium.support.ui.ExpectedConditions;
public class CommonFunctions {
	

	public static boolean waitForVisiblity(WebElement element, int waitTime) {
	boolean result = false;
	try {
		BaseClass.driver.switchTo().activeElement();
	
	     scrolltoElement(element);
	
	     WebDriverWait wait = new WebDriverWait(BaseClass.driver, waitTime);

	     wait.until(ExpectedConditions.visibilityOf(element));
	     result = true;
		} catch (Exception e) {
	
	}
	return result;
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(ConfigFile.screenShot + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	private static void scrolltoElement(WebElement element) {
		try {
			((JavascriptExecutor) BaseClass.driver).executeScript("arguments[0].scrollIntoView(false);", element);
			Thread.sleep(500);
			} catch (Exception e) {
			// e.printStackTrace();
			}
		
	}


}
