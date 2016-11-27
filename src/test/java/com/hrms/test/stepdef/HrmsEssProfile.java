package com.hrms.test.stepdef;

import com.hrms.test.utils.AppConfig;
import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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
    HrmsLogin hrmsLogin;

    public HrmsEssProfile(HrmsLogin hrmsLogin) {
        this.driver = Hooks.driver;
        this.hrmsLogin= hrmsLogin;
    }


    @When("^The user clicks on the profile link from the side bar menu$")
    public void theUserClicksOnTheProfileLinkFromTheSideBarMenu()
    {
        driver.findElement(By.id("ess_profile")).click();
    }

    @Then("^The user is directed to View My Profile Page.$")
    public void theUserIsDirectedToViewMyProfilePage(){
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/h2"),"View My Profile");
    }



    @Given("^A user is at the View My Profile Page after logging in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void aUserIsAtTheViewMyProfilePageAfterLoggingInWithAnd(String username, String password){
        hrmsLogin.aUserCompletesLoginToTheHRMSApplicationWithUsernameAndPassword(username,password);
        theUserClicksOnTheProfileLinkFromTheSideBarMenu();
        theUserIsDirectedToViewMyProfilePage();
    }




    @Given("^A user completes login to the HRMS application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void aUserCompletesLoginToTheHRMSApplicationWithUsernameAndPassword(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The uid label and the value \"([^\"]*)\" is displayed$")
    public void theUidLabelAndTheValueIsDisplayed(String username) {

        // TODO: 27/11/2016  for Rahul to implement
    }

    @And("^The First Name label and the value \"([^\"]*)\" is displayed$")
    public void theFirstNameLabelAndTheValueIsDisplayed(String firstname)
    {
        // TODO: 27/11/2016  for Rahul to implement
    }

    @And("^The Last Name label and the value \"([^\"]*)\" is displayed$")
    public void theLastNameLabelAndTheValueIsDisplayed(String lastname)
    {
        // TODO: 27/11/2016  for Rahul to implement
    }

    @And("^The Email label and the value \"([^\"]*)\" is displayed$")
    public void theEmailLabelAndTheValueIsDisplayed(String email)
    {
        // TODO: 27/11/2016  for Rahul to implement
    }

    @And("^The Address label is displayed$")
    public void theAddressLabelIsDisplayed(){
        // TODO: 27/11/2016  for Rahul to implement
    }

    @And("^The value for Address Line One is displayed as \"([^\"]*)\"$")
    public void theValueForAddressLineOneIsDisplayedAs(String addressline1)  {
        // TODO: 27/11/2016  for Rahul to implement
    }

    @And("^The value for Address Line Two is displayed as \"([^\"]*)\"$")
    public void theValueForAddressLineTwoIsDisplayedAs(String adressline2)
    {
        // TODO: 27/11/2016  for Rahul to implement
    }

    @And("^The value for Address Line Three is displayed as \"([^\"]*)\"$")
    public void theValueForAddressLineThreeIsDisplayedAs(String addressline3)
    {
        // TODO: 27/11/2016  for Rahul to implement
    }
}
