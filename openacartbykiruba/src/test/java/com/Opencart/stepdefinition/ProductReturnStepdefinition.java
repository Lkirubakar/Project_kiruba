package com.Opencart.stepdefinition;

import com.Opencart.pagesobjects.ProductReturnPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductReturnStepdefinition {
	ProductReturnPage prp=new ProductReturnPage();
	@Given("^launching browser for return scenario$")
	public void launching_browser_for_return_scenario() throws Throwable {
	   prp.launchthebrowser("chrome");
	}

	@When("^the user opens the website for product returns$")
	public void the_user_opens_the_website_for_product_returns() throws Throwable {
	   prp.opencart_pag();
	}

	@Then("^the user enters the return details$")
	public void the_user_enters_the_return_details() throws Throwable {
	    prp.product_return();
	}

	@Then("^the user closes the websites$")
	public void the_user_closes_the_websites() throws Throwable {
	 prp.close_returnpage();
	}


}
