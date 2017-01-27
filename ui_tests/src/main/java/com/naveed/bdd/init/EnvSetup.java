package com.naveed.bdd.init;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EnvSetup {
	
	public static String TEST_ENV ;//= System.getProperty("test-env"); // int, test, stage
	public static String TEST_URL ;//= "http://www."+TEST_ENV+".brighttalk.com";
 	public static String HOME_URL ;//= System.getProperty("home-url");
    public static String BROWSER  ;//= System.getProperty("test-browser"); // CHROME or FIREFOX
	public static String USERNAME ;//= System.getProperty("username");
	public static String PASSWORD ;//= System.getProperty("password");

	public static boolean 		WEBDRIVER_FLAG 	= false;
	public static WebDriver		WEB_DRIVER = null;

    @Autowired
    public PropertiesUtil    envProperties;

    @Autowired
    public DriverUtil    driverUtil;

	public EnvSetup(){
        System.out.println("EnvSetup Constructor");
	}

	public  void setWebDriver(){
		try{
			if(WEB_DRIVER == null){
				driverUtil.initWebDriver();
				WEBDRIVER_FLAG = true;
			}
		}catch(Exception ex){
            System.out.println("WebDriver Initialization Failed: "+ex.toString());
        }
	}
		
	public void quitWebDriver(){
		WEB_DRIVER.quit();
		WEBDRIVER_FLAG = false;
        WEB_DRIVER = null;
	}

}
