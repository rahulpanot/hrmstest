package com.hrms.test.utils;




import java.util.Properties;

public class AppConfig {

    public static String BROWSER;
    public static String DRIVER_PATH;
    public static String APP_START_URL;


    static {
        try {
            Properties properties = new Properties();
            properties.load(properties.getClass().getResource("/config/application.properties").openStream());

            BROWSER=properties.getProperty("browser");
            DRIVER_PATH=properties.getProperty("driverpath");
            APP_START_URL=properties.getProperty("appstarturl");


        } catch (Exception e) {
            System.err.println("Unable to read configuration");
            e.printStackTrace();
            System.exit(-1);
        }

    }

}
