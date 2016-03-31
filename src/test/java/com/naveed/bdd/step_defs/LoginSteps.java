package com.naveed.bdd.step_defs;

import com.naveed.bdd.init.EnvSetup;
import com.naveed.bdd.page_objects.Loginpage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class LoginSteps {
 
    private Loginpage login;

//    @Before		//any steps we want to perform before start of each scenario (test)
    public LoginSteps(){  // public void setUp()

        System.out.println("constructor in LoginSteps "+ EnvSetup.WEBDRIVER_FLAG);

        if(!EnvSetup.WEBDRIVER_FLAG){  // if webdriver is not yet set, set it up here
            new EnvSetup().setDriver();			System.out.println("\tEnvSetup Initialized for 1st time");
        }
        login = new Loginpage();
    }

//    @After        //any steps we want to perform after our tests
//    public void tearDown() {
//        System.out.println("\nTearDown runs ");
//        EnvSetup.quitWebDriver();
//
//    }

    @When("^I enter \"([^\"]*)\" in ([^\"]*)$")
    public void I_enter_in_field(String value, String field_name) throws Throwable {
        login.enterDataInField(value,field_name);
    }

}

