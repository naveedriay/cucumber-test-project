package com.naveed.bdd.common;

import com.naveed.bdd.init.EnvSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nriay on 29/07/2015.
 */
public abstract class CommonPage {

//    public static String CURRENT_PAGE = "com.naveed.bdd.page_objects.Homepage";

    public WebDriver driver = null;

    public CommonPage() {
        System.out.println("CommonPage() initialized " + EnvSetup.WEBDRIVER_FLAG);
        driver = EnvSetup.WEB_DRIVER;
    }

    public abstract void pageIsShown();

    public abstract void clickTheElement(String element);

    public abstract String getElementCss(String element);

    public void elementVisibility(String element){  }

    public void verifyElementWithText(String element, String text){}

    public void enterDataInField(String value,String field) {}


}
