package Cucumeber_Automation_Assignment.StefDefs;


import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cucumeber_Automation_Assignment.PageObjects.LandingPage;
import Cucumeber_Automation_Assignment.PageObjects.LogoCommonPage;
import Cucumeber_Automation_Assignment.PageObjects.SearchBar;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StefDefs_automation {
	
	private static final Logger logger = LogManager.getLogger(StefDefs_automation.class);
	
	WebDriver driver;
	String base_url =  "http://automationpractice.com/";
	int implicit_wait_timeout_in_sec = 20;
	int webDriver_timeout_in_sec = 20;
	Scenario scn;
	WebDriverWait wait;
	
	//PageObject Variables
	LandingPage landingPage;
	LogoCommonPage logocommonPage;
	SearchBar searchbar;
	
	@Before
	public void setup(Scenario scn)
	{
		this.scn = scn;		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec,TimeUnit.SECONDS); 
		wait = new WebDriverWait(driver, implicit_wait_timeout_in_sec);
		scn.log("Browser invoked");
		logger.info("Browser invoked");
		
		landingPage = new LandingPage(driver, scn);
		logocommonPage = new LogoCommonPage(driver, scn);
		searchbar = new SearchBar(driver, scn);
	}
	
	 @After
	    public void cleanUp()
	 {
	        driver.quit();
	        scn.log("Browser Closed");
	 }
	 
	 
	
	 		@Given("User navigated to the home application url")
	 		public void user_navigated_to_the_home_application_url() {
		     	driver.get(base_url);	
		     	logger.info("Browser Navigated to url:" +base_url);
	 		}
	 		
	 		@When("User is on application landing page")
	 		public void user_is_on_application_landing_page() {
	 			Assert.assertEquals(true, driver.getCurrentUrl().contains("automationpractice"));
	 			scn.log("Application url contains :- \"automationpractice\"");

	 		}
	 		
	 		@Then("Application url is redirected to {string}")
	 		public void application_url_is_redirected_to(String ApplicationExpectedURL) {
	 			
	 			landingPage.validateURLredirect(ApplicationExpectedURL);
	 		}
		 	 
		 	@Then("Application Title is {string}")
		 	public void application_title_is(String ApplicationExpectedTitle) {
		 		
		 		landingPage.validateApplicationtitle(ApplicationExpectedTitle);
			}

		

			@Then("Application logo is displayed")
			public void application_logo_is_displayed() {
			
				logocommonPage.validateAppLogoIsDisplayed();
			}

			
			@Then("Application logo height is {string}")
			public void application_logo_height_is_displayed(String ApplicatioLogoHeight) {
			
				logocommonPage.validateAppHeightDisplayed(ApplicatioLogoHeight);
			}
			

			@Then("Application logo width is {string}")
			public void application_logo_width_is_displayed(String ApplicationLogoWidth) {
				
				logocommonPage.validateAppWidthDisplayed(ApplicationLogoWidth);
			}

			

			@When("Search box is displayed")
			public void search_box_is_displayed() {
				  
				searchbar.validateSearchBoxElement();
			}


			@When("User Search for {string}")
			public void user_search_for(String NameofProduct) {
					
				searchbar.validateSearchTextElement(NameofProduct);		
			}
				

			@Then("Search box show result containing {string} As more than {int}")
			public void search_box_show_result_containing_as_more_than(String NameofProduct, int CountofProductContainingName){
				
				searchbar.validatelistofProduct(NameofProduct, CountofProductContainingName);
				
			}
}
