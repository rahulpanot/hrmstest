package com.hrms.test.utils;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUpScenario(Scenario scenario) throws Exception
    {
        //open the browser based on the app properties
        switch (AppConfig.BROWSER)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", AppConfig.DRIVER_PATH+ File.separator+"chromedriver.exe");
                ChromeDriver chromeDriver = new ChromeDriver();
                chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                driver=chromeDriver;
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", AppConfig.DRIVER_PATH+ File.separator+"geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            default:
                throw new Exception("Unknown browser. Check application.properties. Allowed values chrome,firefox");

        }
    }

    @After
    public void finishScenario(Scenario scenario)
    {
        if(driver!=null)
            driver.quit();
    }


}
