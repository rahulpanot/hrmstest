package com.hrms.test.stepdef.utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by rahul on 11/20/2016.
 */
public class Demo1 {

    WebDriver driver = null;


    @Given("^I am in the google search screen$")
    public void given_I_am_in_the_google_search_screen() {
        driver = ChromeDriverUtil.getInstance().openBrowserIfNotOpenAndGetDriverRef();
        driver.navigate().to("https://www.google.co.in/?gfe_rd=cr&ei=wLUxWPDJIJHy8Af3grrQDA");
    }


    @When("^I enter selenium tutorial for beginners$")
    public void I_enter_selenium_tutorial() {
        WebElement element = driver.findElement(By.id("1st-ib"));
       //Element.sendkeys("selenium tutorial for beginners");
        driver.close();
    }

    @Then("^page successfully open$")
    public void page_successfully_open() {
        driver = ChromeDriverUtil.getInstance().openBrowserIfNotOpenAndGetDriverRef();
        if (driver.findElement(By.xpath("https://www.google.co.in/search?q=selenium+tutorial+for+beginners&oq=selenium+tutorial+for+beginners&gs_l=serp.12..0i71k1l8.0.0.0.1288214.0.0.0.0.0.0.0.0..0.0....0...1c..64.serp..0.0.0.g1FYN0crYdE")).isDisplayed()) {
            System.out.println("Test 1 Pass");
        } else {
            System.out.println("Test 1 Fail");
        }
    }
}