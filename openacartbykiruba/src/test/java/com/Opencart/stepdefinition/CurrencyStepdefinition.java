package com.Opencart.stepdefinition;


import com.Opencart.pagesobjects.CurrencyPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CurrencyStepdefinition {
	CurrencyPage cp=new CurrencyPage();
	
	@Given("^launching the browser for choosing currency type$")
	public void launching_the_browser_for_choosing_currency_type() throws Throwable {
		cp.launbrow("chrome");
	}

	@When("^the user opens opencart homepage$")
	public void the_user_opens_opencart_homepage() throws Throwable {
	 cp.opencart_pg();
	}

	@Then("^the user select the currency type$")
	public void the_user_select_the_currency_type() throws Throwable {
	    cp.choose_currency();
	}

	@Then("^the user closes the homepage$")
	public void the_user_closes_the_homepage() throws Throwable {
	    cp.close_site();
	}

}
