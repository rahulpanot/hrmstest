package com.hrms.test.stepdef;

import com.hrms.test.utils.AppConfig;
import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by rahul on 11/16/2016.
 */
public class HrmsEssProfile {

    WebDriver driver;

    public HrmsEssProfile() {
        this.driver = Hooks.driver;
    }



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

    @Then(value="^I am greeted to the welcome employee selfservice page$")
    public void I_am_greeted_to_ess_page() {
        driver=Hooks.driver;
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/h2"),"Welcome to Employee Self Services");
    }

    @When(value = "^I click on Profile link on the side menu bar$")
    public void I_cick_on_profile_link()
    {
        driver = Hooks.driver;
        driver.findElement(By.id("ess_profile")).click();

    }

    @Then(value="^I am in the Employee Profile Page$")
    public void I_am_empl_profile_page() {

        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/h2"),"View My Profile");

    }

}
