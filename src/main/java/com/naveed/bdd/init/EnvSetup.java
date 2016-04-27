package com.naveed.bdd.init;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class EnvSetup {
	
	public static String TEST_ENV ;//= System.getProperty("test-env"); // int, test, stage
	public static String TEST_URL ;//= "http://www."+TEST_ENV+".brighttalk.com";
 	public static String HOME_URL ;//= System.getProperty("home-url");// "http://www.brighttalk.com";
    public static String BROWSER  ;//= System.getProperty("test-browser"); // CHROME or FIREFOX
	public static String USERNAME ;//= System.getProperty("username");// "naveed.riay";
	public static String PASSWORD ;//= System.getProperty("password");// "password01";

//    public static boolean       FAIL_FLAG       = false;
	public static boolean 		WEBDRIVER_FLAG 	= false;
	public static WebDriver		WEB_DRIVER = null;

    public        Properties    environmentProperties;

    @Autowired
    public DriverUtil    driverUtil;

	public EnvSetup(){
        // if no properties are found in Test Configuration (IDE settings) then load the properties from config.properties file
        try {
            if(TEST_ENV == null ) {
                environmentProperties = loadProperties("config.properties");
                initializeProperties(environmentProperties);
            }
        } catch (Exception e) {
			System.out.println("Exception In Loading Properties: "+e.toString());
        }

	}

	public  WebDriver getDriver(){
		try{
			if(WEB_DRIVER == null){  System.out.println("WEBDRIVER_FLAG: "+WEBDRIVER_FLAG + " driverUtil: "+driverUtil.toString());
				WEB_DRIVER = driverUtil.getWebDriver();
				WEBDRIVER_FLAG = true;
			}

		}catch(Exception ex){
            System.out.println("WebDriver Initialization Failed: "+ex.toString());
        }
		return WEB_DRIVER;
	}
		
	public void quitWebDriver(){
		WEB_DRIVER.quit();
		WEBDRIVER_FLAG = false;
        WEB_DRIVER = null;
        driverUtil.quitMe();
	}

    private Properties loadProperties(String Properties) throws Exception {
        Properties properties = new Properties();
        InputStream inputStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream(Properties);

        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + Properties + "' not found in the classpath");
        }
        properties.load(inputStream); System.out.println("Properties Loaded");
        return properties;
    }

    private void initializeProperties(Properties env_prop){
        TEST_ENV = env_prop.getProperty("test-env");
        HOME_URL = env_prop.getProperty("home-url");
        BROWSER  = env_prop.getProperty("test-browser");
        USERNAME = env_prop.getProperty("username");
        PASSWORD = env_prop.getProperty("password");
    }
}
