package com.hrms.test.stepdef;

import com.hrms.test.utils.AppConfig;
import com.hrms.test.utils.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by rahul on 11/16/2016.
 */
public class HrmsEssProfileTest {

    WebDriver driver = null;

    @Given("^I am logged in as an employee$")
    public void given_I_am_logged_in_as_an_employee() {
        driver = Hooks.driver;
        driver.navigate().to(AppConfig.APP_START_URL);

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("rahul");
        driver.findElement(By.id("password")).sendKeys("rahul");
        driver.findElement(By.className("btn btn-primary")).click();

    }


    @Given("^I am in the HRMS login screen$")
    public void I_am_in_the_hrms_login_screen() {
        driver = Hooks.driver;
        driver.navigate().to(AppConfig.APP_START_URL);
    }


    @When(value = "^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" and click on the login button$")
    public void I_enter_Username_as_and_Password_as(String username, String password) {

        driver = Hooks.driver;
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }

    @Then("^login should be successful$")
    public void login_should_be_successful() {
        if (driver.getPageSource().contains("Text-Welcome to Employee Self Services")) {
            System.out.println("Text is present");
        } else {
            System.out.println("Text not present");
        }
    @When(value = "^I click on \"([^\\\"]+)\"$/ do |text|$")
            public void I_click_on_string(){
            driver.findElement(By.id("ess_profile")).click();

        }

        }
