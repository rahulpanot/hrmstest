package com.hrms.test.stepdef;

import com.hrms.test.utils.AppConfig;
import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sivan on 27/11/2016.
 */
public class HRMSLogin {

    private WebDriver driver;

    public HRMSLogin() {
        this.driver = Hooks.driver;
    }

    @Given("^A user login to HRMS application with username <\"([^\"]*)\"> and password <\"([^\"]*)\">$")
    public void aUserLoginToHRMSApplicationWithUsernameAndPassword(String username, String password){

    }

    @Then("^The user is directed to the Employee Self Service Page$")
    public void theUserIsDirectedToTheEmployeeSelfServicePage(){

    }

    @And("^A Welcome, <\"([^\"]*)\"> text is present in the right top corner of the navigation bar.$")
    public void aWelcomeTextIsPresentInTheRightTopCornerOfTheNavigationBar(String username){

    }

    @When("^A user launches the HRMS Appplication$")
    public void aUserLaunchesTheHRMSAppplication() {
       driver.navigate().to(AppConfig.APP_START_URL);
    }

    @Then("^The user is directed to the login screen$")
    public void theUserIsDirectedToTheLoginScreen() {
        WebDriverUtil.checkWithWaitIfElementTextValueIs(
                driver,
                By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/h2"),
                "Login");
    }

    @And("^The screen contains field to enter User Name$")
    public void theScreenContainsFieldToEnterUserName()
    {
        String usernamelabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/form/div[1]/label")).getText();
        Assert.assertTrue("User Name:".equals(usernamelabel));
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());

    }

    @And("^The screen contains field to enter Password$")
    public void theScreenContainsFieldToEnterPassword() {

        String passwordlabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/form/div[2]/label")).getText();
        Assert.assertTrue("Password:".equals(passwordlabel));
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());

    }

    @And("^The screen contains a remember me check box$")
    public void theScreeContainsARememberMeCheckBox() throws Throwable {
        Assert.assertTrue(driver.findElement(By.id("rememberMe")).isDisplayed());
        String rememberMeLabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/form/div[3]/div/div/label/text()")).getText();
        Assert.assertTrue(rememberMeLabel.contains("Remember me"));
    }

    @And("^The screen contains a Log in button$")
    public void theScreenContainsALogInButton() {
        Assert.assertTrue(driver.findElement(By.id("login")).isDisplayed());
    }

    @And("^The navigation Bar is empty except for the HRMS brand text.$")
    public void theNavigationBarIsEmptyExceptForTheHRMSBrandText() throws Throwable {
        String navText= driver.findElement(By.id("//*[@id=\"navbar-collapse\"]")).getText();
        if(navText!=null)
        {
            navText=navText.replaceAll("(?:\\n|\\r)", "");
            Assert.assertTrue("HRMS".equals(navText));
        }
    }

    @And("^The following error message(s) is displayed in the screen$")
    public void theFollowingErrorMessageSIsDisplayedInTheScreen(List<String> errors) {

        String error = driver.findElement(By.id("errors")).getText();
        List<String> actualErrors = Arrays.asList(error.split("\\r"));

    }
}
