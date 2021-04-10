@smoke @sanity
Feature: E-commerce Project Web Site of clothes

@RedirectURL
		Scenario: User is able to Open the browser, navigate to the URL and Search for Product
			Given User navigated to the home application url
			When User is on application landing page	
			Then Application url is redirected to "http://automationpractice.com/index.php"
			
@TiteCheck
		Scenario: User is able to Open the browser,navigate to the URL and Search for Product
			Given User navigated to the home application url
			When User is on application landing page
			Then Application Title is "My Store"
	
@AppLogoDisplay
		Scenario: User is able to Open the browser,navigate to the URL and Search for Product
			Given User navigated to the home application url
			When User is on application landing page
			Then Application logo is displayed 
			
@AppLogoHeightDisplay
		Scenario: User is able to Open the browser,navigate to the URL and Search for Product
			Given User navigated to the home application url
			When User is on application landing page
			Then Application logo height is "99"
			
@AppLogoWidthDisplay
		Scenario: User is able to Open the browser,navigate to the URL and Search for Product
			Given User navigated to the home application url
			When User is on application landing page
			Then Application logo width is "350" 
			
@ApplicationSearchBar
		Scenario: User is able to Open the browser,navigate to the URL and Search for Product
			Given User navigated to the home application url
			When Search box is displayed
			And User Search for "Dress"
			Then Search box show result containing "Dress" As more than 5
			

			

	
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
