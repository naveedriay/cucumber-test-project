package com.naveed.bdd.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

/**
 * Created by nriay on 17/07/2015.
 */
@Component
public class DriverUtil {


    private enum BrowserType {
        FIREFOX, CHROME, IE, OPERA, PHANTOM_JS
    }

    public DriverUtil(){
        System.out.println("DriverUtil Constructor");
    }

    public void initWebDriver(){
        try{
            if(EnvSetup.WEB_DRIVER == null){
                EnvSetup.WEB_DRIVER = createWebDriver(DriverUtil.BrowserType.valueOf(EnvSetup.BROWSER));
                System.out.println("\twebdriver initialized for "+ EnvSetup.BROWSER);
            }
        }catch(Exception ex){ }
    }

    private  WebDriver createWebDriver(BrowserType browserType) throws MalformedURLException {
        switch (browserType) {
//            case CHROME:
//                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "C:/Users/C14488A/projects/cucumber-test-project/chromedriver.exe");  // CHROME_DRIVER_EXE_PROPERTY ="webdriver.chrome.driver"
//                DesiredCapabilities cap = DesiredCapabilities.chrome();
//                ChromeDriver chrome = new ChromeDriver(cap);
//                return chrome;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/googlechrome/64bit/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/internetexplorer/64bit/IEDriverServer.exe");
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                return new InternetExplorerDriver(ieCapabilities);
            case OPERA:
                System.setProperty("webdriver.opera.driver","src/test/resources/drivers/operachromium/64bit/operadriver.exe");
                return new OperaDriver();
//            case PHANTOM_JS:
//                    System.setProperty(OperaDriverService.OPERA_DRIVER_EXE_PROPERTY, "src/test/resources/drivers/operachromium/64bit/operadriver.exe"); //"webdriver.opera.driver" System.getProperty("driver-path")
//                    DesiredCapabilities pjs_Capabilities = DesiredCapabilities.phantomjs();
//                    pjs_Capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"");
//                    REAL_DRIVER = new PhantomJSDriver();

            default:
                throw new RuntimeException("Browser Type Unsupported");
        }
    }

}
