package com.hrms.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by rahul on 11/17/2016.
 */
public class WebDriverUtil {


    public static void waitExplicitlyFor(WebDriver driver, By by, long waitUntil, long waitFor)
    {
        if("chrome".equals(AppConfig.BROWSER)) {
            //workaround as the normal explicit wait not working for chrome
            try {
                Thread.currentThread().sleep(waitFor*1000);
            }catch (InterruptedException e )
            {
                e.printStackTrace();
            }
        }
        else
        {
            //explicit wait
            driver.get("http://somedomain/url_that_delays_loading");
            (new WebDriverWait(driver, waitUntil)).until(ExpectedConditions.presenceOfElementLocated(by));
        }
    }


}
