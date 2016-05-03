package com.naveed.bdd.common;

import com.naveed.bdd.init.EnvSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by nriay on 29/07/2015.
 */
public abstract class CommonPage {

    private final int DEFAULT_WAIT = 5; // 5 seconds

    public WebDriver        driver = null;
    public WebDriverWait    driverWait = null;

    public enum WaitConditions{
        elementToBeClickable,elementToBeSelected,elementToAppear, elementToDisappear, textToBePresentInElement
    }

    public CommonPage() {
        System.out.println("CommonPage() initialized " + EnvSetup.WEBDRIVER_FLAG);
        driver = EnvSetup.WEB_DRIVER;
        driverWait = new WebDriverWait(driver, DEFAULT_WAIT);
    }

    public abstract void pageIsShown();

    public abstract void clickTheElement(String element);

    public abstract String getElementCss(String element);

    public void elementVisibility(String element){  }

    public void verifyElementWithText(String element, String text){}

    public void enterDataInField(String value,String field) {}

    public void explicitWaitForElement(WaitConditions condition, By by){
        explicitWaitForElement(condition,by,DEFAULT_WAIT,"");
    }

    public void explicitWaitForElement(WaitConditions condition, By by,int time, String str){ //@Default("5") int time
        driverWait.withTimeout(time, TimeUnit.SECONDS);

        switch (condition){
            case elementToAppear:
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case elementToBeClickable:
            case elementToBeSelected:
                driverWait.until(ExpectedConditions.elementToBeClickable(by));
            case textToBePresentInElement:
                driverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, str));
            case elementToDisappear:
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }
    }

    public void implicitWaitForElement(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

//    public void waitForElementIsSelected(String elementId, Boolean yesOrNo) throws Exception {
//        WebElement element = getWebElement(elementId);
//        driverWait.until(ExpectedConditions.elementSelectionStateToBe(element, yesOrNo));
//    }

}
