package com.hrms.test.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by rahul on 11/17/2016.
 */
public class WebDriverUtil {

    public static final  long RETRY_SLEEP=500;
    public static final long DEFUALT_REQ_TIMEOUT=3000;

    public static void waitExplicitlyFor(WebDriver driver, By by, long waitFor)
    {
        long waittime= waitFor*1000;
        long timewaited = 0;
            while (timewaited <= waittime) {
                try {
                Thread.sleep(1000);
                timewaited = timewaited + 1000;
                if(driver.findElement(by).isDisplayed())
                    break;
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public static void checkWithWaitIfElementTextValueIs(WebDriver driver, By by, String text) {
      checkWithWaitIfElementTextValueIs(driver,by,text,DEFUALT_REQ_TIMEOUT);
    }

    public static void checkWithWaitIfElementTextValueIs(WebDriver driver, By by, String text, long timeout) {
        long timewaited = 0;
        try {
            String actualText="" ;
            while (timewaited <= timeout) {
                try{
                    actualText=driver.findElement(by).getText();
                }catch (StaleElementReferenceException e){}
                if (actualText.equals(text)) {
                    Assert.assertTrue(true);
                    break;
                } else {
                    Thread.currentThread().sleep(RETRY_SLEEP);
                    timewaited=timewaited+RETRY_SLEEP;
                }
            }
            if(timewaited>timeout)
            {
                Assert.fail("Expected Text: "+text+" did not match with Actual Text: "+actualText);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
