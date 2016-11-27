package com.hrms.test.stepdef;

import com.hrms.test.utils.AppConfig;
import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class HrmsLogin {

    private WebDriver driver;

    public HrmsLogin() {
        this.driver = Hooks.driver;
    }

    @Given("^A user attempts to login to HRMS application with username <\"([^\"]*)\"> and password <\"([^\"]*)\">$")
    public void aUserAttempsToLoginToHRMSApplicationWithUsernameAndPassword(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }



    @Then("^The user is directed to the Employee Self Service Page$")
    public void theUserIsDirectedToTheEmployeeSelfServicePage(){

        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/h2"),"Welcome to Employee Self Services");

    }

    @And("^A Welcome, <\"([^\"]*)\"> text is present in the right top corner of the navigation bar.$")
    public void aWelcomeTextIsPresentInTheRightTopCornerOfTheNavigationBar(String username){
        String expectedText="Welcome, "+username;
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"usermenu\"]")).getText().trim().equals(expectedText));
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
        String rememberMeLabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/form/div[3]/div/div/label")).getText();
        Assert.assertTrue(rememberMeLabel.contains("Remember me"));
    }

    @And("^The screen contains a Log in button$")
    public void theScreenContainsALogInButton() {
        Assert.assertTrue(driver.findElement(By.id("login")).isDisplayed());
    }


    @And("^The view selection menu is selected with <\"([^\"]*)\"> in the navigation bar.$")
    public void theViewSelectionMenuIsSelectedWithInTheNavigationBar(String defaultedText) {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"switchviewmenu\"]")).getText().equals(defaultedText));
    }

    @And("^The following error message is displayed in the screen$")
    public void theFollowingErrorMessageIsDisplayedInTheScreen(List<String> expectederroMsgs)
    {

        List<String> actualErrors= Arrays.asList(driver.findElement(By.id("errors")).getText().split("\\r"));

        Assert.assertTrue("Expected Error messages "+expectederroMsgs+" did not equal actual "+actualErrors,
                expectederroMsgs.equals(actualErrors));
    }

    @And("^The navigation Bar does not show welcome user name and view menu.$")
    public void theNavigationBarDoesNotShowWelcomeUserNameAndViewMenu() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"usermenu\"]")).getText().trim().equals(""));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"switchviewmenu\"]")).getText().trim().equals(""));
    }

    @Given("^A user completes login to the HRMS application with username <\"([^\"]*)\"> and password <\"([^\"]*)\">$")
    public void aUserCompletesLoginToTheHRMSApplicationWithUsernameAndPassword(String username, String password) {
        aUserLaunchesTheHRMSAppplication();
        aUserAttempsToLoginToHRMSApplicationWithUsernameAndPassword(username,password);
        theUserIsDirectedToTheEmployeeSelfServicePage();
    }
}
