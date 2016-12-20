package com.naveed.bdd.common;

import com.naveed.bdd.init.EnvSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by nriay on 29/07/2015.
 */
public abstract class CommonPage {

    private final int DEFAULT_WAIT = 5;

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

    public abstract void elementVisibility(String element);

    public void verifyElementWithText(String element, String text){}

    public void enterDataInField(String value,String field) {}

    public void explicitWaitForElement(WaitConditions condition, By by){
        explicitWaitForElement(condition,by,DEFAULT_WAIT,"");
    }

    public void explicitWaitForElement(WaitConditions condition, By by,int time, String str){ //@Default("5") int time
        driverWait.withTimeout(time, TimeUnit.SECONDS);

        switch (condition){
            case elementToAppear:
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(by)); break;
            case elementToBeClickable:
            case elementToBeSelected:
                driverWait.until(ExpectedConditions.elementToBeClickable(by)); break;
            case textToBePresentInElement:
                driverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, str)); break;
            case elementToDisappear:
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(by)); break;
        }
    }

    public void implicitWaitForElement(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

//    public void waitForElementIsSelected(String elementId, Boolean yesOrNo) throws Exception {
//        WebElement element = getWebElement(elementId);
//        driverWait.until(ExpectedConditions.elementSelectionStateToBe(element, yesOrNo));
//    }

    protected WebElement find(By locator) {
        try {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollIntoView(locator));
            wait_until_true_or_timeout(ExpectedConditions.elementToBeClickable(locator));
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException(ex.getMessage());
        }
        return driver.findElement(locator);
    }
    // wait until condition is true or timeout is reached
    protected <V> V wait_until_true_or_timeout(ExpectedCondition<V> isTrue) {
        Wait<WebDriver> wait = new WebDriverWait(driver, DEFAULT_WAIT*1000).ignoring(StaleElementReferenceException.class);
        try {
            return wait.until(isTrue);
        } catch (TimeoutException rte) {
            throw new TimeoutException(rte.getMessage() );
        }
    }

    public WebElement scrollIntoView(By locator) throws InterruptedException{
        WebElement element = driver.findElement(locator);
        System.out.println(element.toString()+ " isElementInViewport() "+isElementInViewport(element));
        if (!element.isDisplayed() || !isElementInViewport(element)) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + (element.getLocation().y - 100) + ");", element);
            Thread.sleep(500);
        }
        return element;
    }

    public boolean isElementInViewport(WebElement element) {
        return (boolean) ((JavascriptExecutor) driver)
                .executeScript(
                        "var rect     = arguments[0].getBoundingClientRect(); " +
                                "var vWidth   = window.innerWidth || document.documentElement.clientWidth; " +
                                "var vHeight  = window.innerHeight || document.documentElement.clientHeight; " +

                                "return ( rect.right > 0 && rect.bottom > 0 && rect.left < vWidth && rect.top < vHeight " +
                                "&&  arguments[0].contains(document.elementFromPoint(rect.left,  rect.top)) " +
                                "&&  arguments[0].contains(document.elementFromPoint(rect.right, rect.top)) " +
                                "&&  arguments[0].contains(document.elementFromPoint(rect.right, rect.bottom)) " +
                                "&&  arguments[0].contains(document.elementFromPoint(rect.left,  rect.bottom)) " +
                                ");", element);
    }
}
