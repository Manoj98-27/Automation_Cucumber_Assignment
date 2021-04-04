package Cucumeber_Automation_Assignment.StefDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class StefDefs_automation {
	
	WebDriver driver;
	String base_url =  "http://automationpractice.com/";
	int implicit_wait_timeout_in_sec = 20;
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec,TimeUnit.SECONDS);
		
	}
	
	 @After
	    public void cleanUp()
	 {
	        driver.quit();
	 }

}
