package com.naveed.bdd.init;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nriay on 28/04/2016.
 */
@Component
public class PropertiesUtil {

    private final String properties_path = "config.properties";

    public PropertiesUtil() throws Exception {
        System.out.println("PropertiesUtil Constructor");
        // if no properties are found in Test Configuration (IDE settings) then load the properties from config.properties file
        try {
            if(EnvSetup.TEST_ENV == null ) {
                loadProperties(properties_path);
            }
        } catch (Exception e) {
        System.out.println("Exception Loading Properties: "+e.toString());
        }

    }

    public void loadProperties(String Properties) throws Exception {
        Properties properties = new Properties();
        InputStream inputStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream(Properties);

        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + Properties + "' not found in the classpath");
        }
        properties.load(inputStream); System.out.println("Properties Loaded");
        initializeProperties(properties);
    }

    private void initializeProperties(Properties env_prop){
        EnvSetup.TEST_ENV = env_prop.getProperty("test-env");
        EnvSetup.HOME_URL = env_prop.getProperty("home-url");
        EnvSetup.BROWSER  = env_prop.getProperty("test-browser");
        EnvSetup.USERNAME = env_prop.getProperty("username");
        EnvSetup.PASSWORD = env_prop.getProperty("password");
    }
}
