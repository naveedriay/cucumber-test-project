package com.naveed.bdd.step_defs;

import com.naveed.bdd.page_objects.Loginpage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class LoginSteps {
 
    private Loginpage login;

    public LoginSteps(){
        login = new Loginpage();
    }

    @When("^I enter \"([^\"]*)\" in ([^\"]*)$")
    public void I_enter_in_field(String value, String field_name) throws Throwable {
        login.enterDataInField(value,field_name);
    }

}

