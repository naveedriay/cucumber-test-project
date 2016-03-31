package com.naveed.bdd.page_objects;

import com.naveed.bdd.common.CommonPage;
import com.naveed.bdd.init.EnvSetup;
import com.naveed.bdd.page_elements.LoginElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

public class Loginpage extends CommonPage implements LoginElements {

    public Field field = null;

    public Loginpage() {
        System.out.println("Loginpage() initialized");
    }

    public void pageIsShown(){
        Assert.assertTrue(driver.findElement(By.cssSelector(header)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(footer)).isDisplayed());

        driver.findElement(By.cssSelector(current_date));
        driver.findElement(By.cssSelector(today_exchange_rate));
        driver.findElement(By.cssSelector(new_user_registration_link));
        driver.findElement(By.cssSelector(forgot_password_link));
    }

    public void clickTheElement(String element_name){
        driver.findElement(By.cssSelector(getElementCss(element_name))).click();
    }

    public String getElementCss(String elementName) {
        String className = "com.naveed.bdd.page_objects.Loginpage";
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

        Assert.assertTrue(element_name+" is not visible", driver.findElement(By.cssSelector(getElementCss(element_name))).isDisplayed());
    }

    public void enterDataInField(String data, String field_name){
        driver.findElement(By.cssSelector(getElementCss(field_name))).sendKeys(data);
    }

}
