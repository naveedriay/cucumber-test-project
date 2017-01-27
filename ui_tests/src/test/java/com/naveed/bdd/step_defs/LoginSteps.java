package com.naveed.bdd.step_defs;

import com.naveed.bdd.page_objects.EbayLoginpage;

import cucumber.api.java.en.When;
 
public class LoginSteps {
 
    private EbayLoginpage login;

    public LoginSteps(){
        login = new EbayLoginpage();
    }

    @When("^I enter \"([^\"]*)\" in ([^\"]*)$")
    public void I_enter_in_field(String value, String field_name) throws Throwable {
        login.enterDataInField(value,field_name);
    }

}

