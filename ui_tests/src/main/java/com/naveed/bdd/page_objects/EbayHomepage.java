package com.naveed.bdd.page_objects;


import com.naveed.bdd.common.CommonPage;
import com.naveed.bdd.page_elements.EbayHomepageElements;
import com.naveed.bdd.init.EnvSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class EbayHomepage extends CommonPage implements EbayHomepageElements {

    public Field field = null;
    private WebDriver driver = EnvSetup.WEB_DRIVER;

    public EbayHomepage() {
        System.out.println("EbayHomepage() initialized");
    }

    public void openPage() {
    	
    	driver.get(EnvSetup.TEST_URL);
        driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // wait to load the page
    		
    }

	public void openPage(String sitename) {
        System.out.println(EnvSetup.HOME_URL +" WebDriver:"+driver);
        if(driver != null) {
            driver.navigate().to(EnvSetup.HOME_URL); // or can use "https://www."+sitename+".com"
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // wait to load the page
        }
	}
    
    public void pageIsShown() {
        //    	new WebElementWaiter().waitAndFindByXpath(driver, "//*[@id='logo']/img");
    	assertTrue(find(By.cssSelector(navigation_bar)).isDisplayed());
        assertTrue(find(By.cssSelector(site_footer)).isDisplayed());
        assertTrue(find(By.cssSelector(site_header)).isDisplayed());
        assertTrue(find(By.cssSelector(headerLogo)).isDisplayed());
        assertTrue(find(By.cssSelector(myEbayLink)).isDisplayed());
    }
    
	public void clickTheElement(String element_name){
		find(By.cssSelector(getElementCss(element_name))).click();
	}

    public String getElementCss(String elementName) {
        String className = "com.naveed.bdd.page_objects.EbayHomepage";
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

        assertTrue(element_name+" is not visible", find(By.cssSelector(getElementCss(element_name))).isDisplayed());
    }
    
  }

