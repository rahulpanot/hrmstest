package com.hrms.test.stepdef.utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rahul on 11/20/2016.
 */
public class Fipkart {


    WebDriver driver = null;
    @Given("^I am in the Flipkart Screen$")
    public void I_am_in_the_Flipkart_Screen()
    {
        driver = ChromeDriverUtil.getInstance().openBrowserIfNotOpenAndGetDriverRef();
        driver.navigate().to("https://www.flipkart.com/");
    }
    @When("^I click Log In$")
    public void I_click_Log_In()
    {
        driver = ChromeDriverUtil.getInstance().openBrowserIfNotOpenAndGetDriverRef();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div[1]/div/ul/li[9]/a")).click();
    }
}