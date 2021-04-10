package Cucumeber_Automation_Assignment.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class LogoCommonPage {
	
		private static final Logger logger = LogManager.getLogger(LogoCommonPage.class);
		
		WebDriver driver;
		WebDriverWait wait;
		Scenario scn;
		
		public LogoCommonPage(WebDriver driver, Scenario scn)
		{
			this.driver = driver;
			this.scn = scn;
			wait = new WebDriverWait(driver, 20);
		}
		//Locators
		private By ApplicationLogoElement = By.xpath("//div[@id='header_logo']//img[@class='logo img-responsive']");
		

		//Methods
		
		public void validateAppLogoIsDisplayed()
		{
			
		  WebElement ApplicationLogo = driver.findElement(ApplicationLogoElement);
		  wait.until(ExpectedConditions.visibilityOf(ApplicationLogo));
		  Assert.assertEquals(true,ApplicationLogo.isDisplayed());
		  scn.log("Application Logo is Displayed :-" +ApplicationLogo.isDisplayed());
		}
		
		public void validateAppHeightDisplayed(String ApplicatioLogoHeight)
		{
			  WebElement ApplicationLogoHeightElement = driver.findElement(ApplicationLogoElement);
			  wait.until(ExpectedConditions.visibilityOf(ApplicationLogoHeightElement));
			  Assert.assertEquals("error",ApplicatioLogoHeight,String.valueOf(ApplicationLogoHeightElement.getAttribute("Height")));
			  scn.log("Applicatin Logo Height is Displayed :- "+ApplicationLogoHeightElement.getAttribute("Height"));

		}
		
		public void validateAppWidthDisplayed(String ApplicationLogoWidth)
		{
			WebElement ApplicationLogoWidthElement = driver.findElement(ApplicationLogoElement);
			wait.until(ExpectedConditions.visibilityOf(ApplicationLogoWidthElement));
			Assert.assertEquals("error",ApplicationLogoWidth,String.valueOf(ApplicationLogoWidthElement.getAttribute("Width")));
			logger.info("Application Logo of Width is Displayed :- "+ApplicationLogoWidthElement.getAttribute("Width"));
		}
}
