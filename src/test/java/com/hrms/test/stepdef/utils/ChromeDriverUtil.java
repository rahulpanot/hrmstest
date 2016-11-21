package com.hrms.test.stepdef.utils;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by rahul on 11/17/2016.
 */
public class ChromeDriverUtil {
    private static ChromeDriverUtil ourInstance = new ChromeDriverUtil();
    private static ChromeDriver driver = null;

    public static ChromeDriverUtil getInstance() {
        return ourInstance;
    }

    private ChromeDriverUtil() {
    }

    public ChromeDriver openBrowserIfNotOpenAndGetDriverRef()
    {
        if(driver==null)
        {
            System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            return driver;
        }
        else
        {
            return driver;
        }

    }

    public void closeBrowser()
    {
        driver.close();
        driver =null;
    }


}
