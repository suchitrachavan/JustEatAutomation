package Helpers;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;



import Config.ConfigFile;

public class BaseClass {
	
	public static ChromeDriver driver;
	

	
	public static void LogintoJustEat()
	{
	
	
	String chromePath=ConfigFile.currentDirectory+"//WebDriver//chromedriver.exe";
	
	System.setProperty("webdriver.chrome.driver", chromePath);
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("http://www.just-eat.co.uk/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	}

}
