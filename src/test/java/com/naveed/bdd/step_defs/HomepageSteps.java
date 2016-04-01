package com.naveed.bdd.step_defs;

import com.naveed.bdd.page_objects.Homepage;
import com.naveed.bdd.init.EnvSetup;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class HomepageSteps{
	
	private Homepage		home;

    public HomepageSteps(){
		home = new Homepage();
    }

	@Given("^user is on internet$")
	public void the_site_visitor_is_on_internet() throws Throwable {

	}

	@When("^I load the (.*?) page$")
	public void user_opens_the_homepage_for(String page_url) throws Throwable {
		if(page_url.contains("int") || page_url.contains("test") || page_url.contains("stage"))
			home.openPage();
		else
			home.openPage(page_url);
	}

}
    
