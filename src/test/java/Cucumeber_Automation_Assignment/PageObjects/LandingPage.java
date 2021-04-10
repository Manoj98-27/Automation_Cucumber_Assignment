package Cucumeber_Automation_Assignment.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class LandingPage {

	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	public LandingPage(WebDriver driver, Scenario scn)
	{
		this.driver = driver;
		this.scn = scn;
		wait = new WebDriverWait(driver, 20);
	}
	 
	
	public void validateApplicationtitle(String ApplicationExpectedTitle) 
	{
		Assert.assertEquals(ApplicationExpectedTitle, driver.getTitle());
		  logger.info("Application Title is Successfully :-" +driver.getTitle());
	}
	
	public void validateURLredirect(String ApplicationExpectedURL)
	{
		Assert.assertEquals(ApplicationExpectedURL, driver.getCurrentUrl());
			scn.log("Application URL is Successfully Redirected to :-" + driver.getCurrentUrl());
	}
	
	
	
}
