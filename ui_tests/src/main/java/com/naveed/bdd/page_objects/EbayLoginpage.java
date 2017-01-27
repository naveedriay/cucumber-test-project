package com.naveed.bdd.page_objects;

import com.naveed.bdd.common.CommonPage;
import com.naveed.bdd.page_elements.EbayLoginElements;
import org.openqa.selenium.By;
import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class EbayLoginpage extends CommonPage implements EbayLoginElements {

    public Field field = null;

    public EbayLoginpage() {
        System.out.println("EbayLoginpage() initialized");
    }

    public void pageIsShown(){
        assertTrue(find(By.cssSelector(header)).isDisplayed());
        assertTrue(find(By.cssSelector(footer)).isDisplayed());

        find(By.cssSelector(current_date));
        find(By.cssSelector(today_exchange_rate));
        find(By.cssSelector(new_user_registration_link));
        find(By.cssSelector(forgot_password_link));
    }

    public void clickTheElement(String element_name){
        find(By.cssSelector(getElementCss(element_name))).click();
    }

    public String getElementCss(String elementName) {
        String className = "com.naveed.bdd.page_objects.EbayLoginpage";
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

    public void enterDataInField(String data, String field_name){
        find(By.cssSelector(getElementCss(field_name))).sendKeys(data);
    }

}
