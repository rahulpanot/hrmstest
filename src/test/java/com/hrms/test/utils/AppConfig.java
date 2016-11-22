package com.hrms.test.utils;


import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    public static String BROWSER;
    public static String DRIVER_PATH;
    public static String APP_START_URL;

    static {
        Configurations configs = new Configurations();
        try {
            Properties properties = new Properties();
            properties.load(properties.getClass().getResource("/config/application.properties").openStream());
            //InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("application.properties");
//            Configuration config = configs.properties("/config/application.properties");
//            Properties properties = new Properties();
//            properties.load(inputStream);

            BROWSER=properties.getProperty("browser");
            DRIVER_PATH=properties.getProperty("driverpath");
            APP_START_URL=properties.getProperty("appstarturl");
//            BROWSER=config.getString("browser");
//            DRIVER_PATH=config.getString("driverpath");
//            APP_START_URL=config.getString("appstarturl");

        } catch (Exception e) {
            System.err.println("Unable to read configuration");
            e.printStackTrace();
            System.exit(-1);
        }

    }

}
