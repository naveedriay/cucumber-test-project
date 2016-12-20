package com.naveed.bdd.page_objects;

import com.naveed.bdd.common.CommonPage;
import com.naveed.bdd.page_elements.SubscriptionElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

/**
 * Created by nriay on 03/08/2015.
 */
public class SubscriptionPage  extends CommonPage implements SubscriptionElements {

    public Field field = null;

    public SubscriptionPage() {
        System.out.println("SubscriptionPage() initialized");
    }

    public  void pageIsShown(){
        assertTrue(find(By.cssSelector(subscription_section_header)).isDisplayed());
        assertTrue(find(By.cssSelector(selected_product_type)).isDisplayed());
        assertTrue(find(By.cssSelector(all_beneficiary_list)).isDisplayed());
    }

    public  void clickTheElement(String element){
        find(By.cssSelector(getElementCss(element))).click();
    }

    public  String getElementCss(String elementName){
        String className = "com.naveed.bdd.page_objects.SubscriptionPage";
        String elementCss = "";
        try {
            field = Class.forName(className).getField(elementName);
            field.setAccessible(true);
            Object o = field.get(Class.forName(className).newInstance());
            if(o instanceof String) elementCss = (String) o;
        }
        catch (Exception e) { e.printStackTrace();  }
        return elementCss;
    }

    public void elementVisibility(String element_name){
        explicitWaitForElement(WaitConditions.elementToAppear, By.cssSelector(getElementCss(element_name)));
//        Assert.assertTrue(element_name + " is not visible", find(By.cssSelector(getElementCss(element_name))).isDisplayed());
    }

    public void verifyElementWithText(String element_name, String expected_text){

        WebElement element = find(By.cssSelector(getElementCss(element_name)));
        boolean visibility = element.isDisplayed();
        if(visibility){
            if((element.getText().contains(expected_text)))
                assertTrue("matched", true);
            else
                Assert.assertFalse("Not Matched", true);
        }
        else {
            assertTrue(element_name + " is not visible", false);
        }
    }
}
