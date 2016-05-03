package com.naveed.bdd.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

/**
 * Created by nriay on 17/07/2015.
 */
@Component
public class DriverUtil {


    private enum BrowserType {
        FIREFOX, MACCHROME, CHROME, GRIDFIREFOX, GRIDCHROME, MACFIREFOX
    }

    public DriverUtil(){
        System.out.println("DriverUtil Constructor");
    }

    public void initWebDriver(){
        try{
            if(EnvSetup.WEB_DRIVER == null){
                EnvSetup.WEB_DRIVER = createWebDriver("FIREFOX"); //DriverUtil.BrowserType.valueOf(EnvSetup.BROWSER)
                System.out.println("\twebdriver initialized for "+ EnvSetup.BROWSER);
            }
        }catch(Exception ex){ }
    }

    private  WebDriver createWebDriver(String browserType) throws MalformedURLException {
        switch (browserType) {
//			case MACCHROME:
//				return new ChromeDriver(getDesiredCapabilities(BrowserType.MACCHROME));
//                return new RemoteWebDriver(new URL(seleniumGridUrl), decaps(BrowserType.MACCHROME)); P:\eclipse_workspace\cucumber-test-project\chromedriver.exe
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "P:/eclipse_workspace/maven-project/chromedriver.exe");
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                ChromeDriver chrome = new ChromeDriver(cap);
                return chrome;
//                return new RemoteWebDriver(getDesiredCapabilities(BrowserType.CHROME));
//                return new ChromeDriver(getDesiredCapabilities(BrowserType.CHROME));
            case "FIREFOX":
                return new FirefoxDriver(getDesiredCapabilities(BrowserType.FIREFOX));
            default:
                throw new RuntimeException("Browser Type Unsupported");
        }
    }

    private  DesiredCapabilities getDesiredCapabilities(BrowserType browserType) {
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "P:/eclipse_workspace/maven-project/chromedriver.exe");
                return DesiredCapabilities.chrome();
            case FIREFOX:
//                return DesiredCapabilities.firefox();
                FirefoxProfile profile = new FirefoxProfile();
                cap.setCapability(FirefoxDriver.PROFILE, profile);
                return cap;
            default:
                throw new RuntimeException("Unsupported Capability");
        }
    }

}
