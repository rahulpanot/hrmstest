package com.hrms.test.stepdef;

import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by rahul on 11/16/2016.
 */
public class HrmsEssProfileTest {

    WebDriver driver = null;

    @Given("^I am logged in as an employee$")
    public void given_I_am_logged_in_as_an_employee() {
        driver = Hooks.driver;
        driver.navigate().to("https://intense-brushlands-38197.herokuapp.com");

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("rahul");
        driver.findElement(By.id("password")).sendKeys("rahul");
        driver.findElement(By.className("btn btn-primary")).click();

    }



    @Given("^I am in the HRMS login screen$")
    public void I_am_in_the_hrms_login_screen()
    {
        driver = Hooks.driver;
        driver.navigate().to("https://hrmsdemo.herokuapp.com/#!/login");
    }


    @When(value = "^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" and click on the login button$")
    public void I_enter_Username_as_and_Password_as(String username, String password) {

        driver = Hooks.driver;
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }

    @Then("^login should be successful$")
    public void validateRelogin() {
        driver = Hooks.driver;

        if (driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/h2")).isDisplayed()){
            System.out.println("Test 1 Pass");
        } else {
            System.out.println("Test 1 Fail");
        }

    }
    @Then("^I close the browser$")
    public void i_close_the_browser()
    {
        Hooks.driver.close();
    }


}
