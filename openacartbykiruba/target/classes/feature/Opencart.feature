@Testcase_Feature
Feature: Opencart website 

@tc01_opencart_register
Scenario: Register in opencart website 
	
	Given the user launch the browser for register
	When the  user opens opencart register page
	Then the user enters the valid register details
	Then the user close the opencart register page
	

@tc02_opencart_login
Scenario Outline: Login in opencart website
	
	Given the user launch the browser for login
	When the  user opens opencart login page
	Then The user enters "<emailid>" and "<pass>"
	Then the user close the opencart login page
	
Examples:
|emailid					|pass			|
|soundaryariya27@gmail.com	|sound			|
|sound						|sound11		|

@tc03_opencart_choosecurrency
Scenario: Choose currency type in opencart website
	
	Given launching the browser for choosing currency type
	When the user opens opencart homepage
	Then the user select the currency type
	Then the user closes the homepage

	
@tc04_opencart_choosebrand
Scenario: Choose the company brand in open cart website
	
	Given launching the browser for choosing the brand
	When the user opens the opencart homepage
	Then the user select the brand
	Then the user close the homepage

@tc05_opencart_contactus
Scenario: Contact us in open cart website
	
	Given launching browser for contactus scenario
	When the user opens the website
	Then the user enters the contactus details
	Then the user closes the website
@tc06_opencart_return
Scenario: Product return in open cart website
	
	Given launching browser for return scenario
	When the user opens the website for product returns
	Then the user enters the return details
	Then the user closes the websites