package com.naveed.bdd.step_defs;

import com.naveed.bdd.common.CommonPage;
import com.naveed.bdd.common.LoadPage;
import com.naveed.bdd.init.EnvSetup;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;


import java.util.List;

/**
 * Created by nriay on 17/07/2015.
 */
public class CommonSteps {

    private CommonPage  page;
    private LoadPage    page_object;

    @Before		//any steps we want to perform before start of each scenario (test)
    public void setUp(){
        System.out.println("setup in CommonSteps\nWebDriver:"+ EnvSetup.WEBDRIVER_FLAG);

        if(!EnvSetup.WEBDRIVER_FLAG){  // if webdriver is not yet set, set it up here
            new EnvSetup().getDriver();			System.out.println("EnvSetup Initialized in CommonSteps.\nWebDriver Initialized: "+ EnvSetup.WEBDRIVER_FLAG);
        }
        page_object = new LoadPage();
    }

    @After		//any steps we want to perform after our tests
    public void tearDown() {
        System.out.println("\nTearDown runs in CommonSteps");
        EnvSetup.quitWebDriver();
    }

    @Given("^I am on ([^\"]*)$")
    public void I_am_on_page(String className) throws Throwable {
//        CommonPage.CURRENT_PAGE = "com.naveed.bdd.page_objects."+className;
//        page = (Homepage)Class.forName(CommonPage.CURRENT_PAGE).newInstance();
        switch(className){
            case "Homepage":
                page = page_object.getHomepage(); break;
            case "Loginpage":
                page = page_object.getLoginpage(); break;
            case "SubscriptionPage":
                page = page_object.getSubscriptionPage(); break;
        }

    }

    @Then("^I should see ([^\"]*) loaded successfully$")
    public void I_should_see_loaded_successfully(String arg1) throws Throwable {
        page.pageIsShown();
        EnvSetup.FAIL_FLAG = true;
    }

    @When("^I click on ([^\"]*)$")
    public void I_click_on(String elementName) throws Throwable {

        page.clickTheElement(elementName);
    }

    @And("^element ([^\"]*) is visible$")
    public void element_is_visible(String element_name) throws Throwable {
        page.elementVisibility(element_name);
        Thread.sleep(1000);
    }


    @And("^the following elements are visible$")
    public void the_following_elements_are_visible(DataTable table) throws Throwable {
        for (List<String> rows : table.raw()) {
            page.elementVisibility(rows.get(0));

        }
    }

    @And("^I should see ([^\"]*) containing text \"([^\"]*)\"$")
    public void I_should_see_with_text(String element_name, String expected_text) throws Throwable {
        page.verifyElementWithText(element_name, expected_text);
    }

    @When("^I entered ([^\"]*) in ([^\"]*)$")
    public void I_entered_in(String property_name, String field_name) throws Throwable {
        //String value = System.getProperty(property_name);
        property_name =  (property_name.equals("username"))? EnvSetup.USERNAME : EnvSetup.PASSWORD;
        page.enterDataInField(property_name,field_name);
    }
}
