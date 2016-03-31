package com.naveed.bdd.page_objects;


import com.naveed.bdd.common.CommonPage;
import com.naveed.bdd.page_elements.HomepageElements;
import com.naveed.bdd.init.EnvSetup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;


public class Homepage extends CommonPage implements HomepageElements {

    public Field field = null;
    private WebDriver driver = EnvSetup.WEB_DRIVER;

    public Homepage() {
        System.out.println("Homepage() initialized");
    }

    public void openPage() {
    	
    	driver.get(EnvSetup.TEST_URL);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // wait to load the page
    		
    }

	public void openPage(String sitename) {
        System.out.println(EnvSetup.HOME_URL +" WebDriver:"+driver);
        if(driver != null) {
            driver.get(EnvSetup.HOME_URL); // or can use "https://www."+sitename+".com"
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // wait to load the page
        }
	}
    
    public void pageIsShown() {
        //    	new WebElementWaiter().waitAndFindByXpath(driver, "//*[@id='logo']/img");
    	Assert.assertTrue(driver.findElement(By.cssSelector(pkr_panel)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(loginLink)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(loginform)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(headerLogo)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(headerImage)).isDisplayed());
    }
    
	public void clickTheElement(String element_name){
		driver.findElement(By.cssSelector(getElementCss(element_name))).click();
	}

    public String getElementCss(String elementName) {
        String className = "com.naveed.bdd.page_objects.Homepage";
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
    
  }

