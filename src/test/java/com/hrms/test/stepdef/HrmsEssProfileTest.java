package com.hrms.test.stepdef;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by rahul on 11/16/2016.
 */
public class HrmsEssProfileTest {

    WebDriver driver = null;

    @Given("^I am logged in as an employee$")
    public void given_I_am_logged_in_as_an_employee()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://intense-brushlands-38197.herokuapp.com");
        driver.close();
    }

}
