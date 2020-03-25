package com.Opencart.stepdefinition;


import com.Opencart.pagesobjects.BrandsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BrandsStepdefinition 
{
	BrandsPage br=new BrandsPage();
	
	@Given("^launching the browser for choosing the brand$")
	public void launching_the_browser_for_choosing_the_brand() throws Throwable 
	{
	   br.launchapp("chrome");
	}

	@When("^the user opens the opencart homepage$")
	public void the_user_opens_the_opencart_homepage() throws Throwable 
	{
	 br.opencart_web();
	}

	@Then("^the user select the brand$")
	public void the_user_select_the_brand() throws Throwable 
	{
		br.choose_brands();
	}

	@Then("^the user close the homepage$")
	public void the_user_close_the_homepage() throws Throwable 
	{
	    br.close_the_browser();
	}
}
