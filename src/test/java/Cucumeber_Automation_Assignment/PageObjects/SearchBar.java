package Cucumeber_Automation_Assignment.PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class SearchBar {
	private static final Logger logger = LogManager.getLogger(LogoCommonPage.class);
	
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	public SearchBar(WebDriver driver, Scenario scn)
	{
		this.driver = driver;
		this.scn = scn;
		wait = new WebDriverWait(driver, 20);
	}
	
	//Locators
	private By SearchBoxElement = By.xpath("//input[@id='search_query_top']");

	private By ListofProductElement = By.xpath("//div[@class='ac_results']/ul/li");
	//Methods
	public void validateSearchBoxElement()
	{
		 WebElement SearchBox = driver.findElement(SearchBoxElement);
		   wait.until(ExpectedConditions.visibilityOf(SearchBox));
		   Assert.assertEquals(true,SearchBox.isDisplayed());
		   logger.info("Search Bar is Displayed:- "+SearchBox.isDisplayed());
	}
	
	public void validateSearchTextElement(String NameofProduct)
	{
		 WebElement SearchBox = driver.findElement(SearchBoxElement);
		 SearchBox.sendKeys(NameofProduct);
		 wait.until(ExpectedConditions.visibilityOf(SearchBox));
	}
	
	public void validatelistofProduct(String NameofProduct, int CountofProductContainingName)
	{
		List<WebElement> SearchProduct = driver.findElements(ListofProductElement);
		wait.until(ExpectedConditions.visibilityOfAllElements(SearchProduct));
		
		int CountofDressProuduct = 0;
		
		for(int i=0; i<SearchProduct.size(); i++)
		{
			if(SearchProduct.get(i).getText().contains(NameofProduct))
			{
				logger.info((i+1 + ". " + SearchProduct.get(i).getText()));
				CountofDressProuduct++;
			}
		}
 logger.info("Total Product Dress count:"+ CountofDressProuduct);
 Assert.assertEquals("Product Count Does not match",CountofProductContainingName,CountofDressProuduct);
		
	}
}
