package com.hrms.test.stepdef;

import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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





    @Then("^The uid label and the value \"([^\"]*)\" is displayed$")
    public void theUidLabelAndTheValueIsDisplayed(String username) {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[1]")).getText().equals("uid:"));
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]"),username);
    }

    @And("^The First Name label and the value \"([^\"]*)\" is displayed$")
    public void theFirstNameLabelAndTheValueIsDisplayed(String firstname)
    {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]")).getText().equals("First Name:"));
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]"),firstname);
    }

    @And("^The Last Name label and the value \"([^\"]*)\" is displayed$")
    public void theLastNameLabelAndTheValueIsDisplayed(String Lastname)
    {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[3]/div[1]")).getText().equals("Last Name:"));
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[3]/div[2]"),Lastname);
    }

    @And("^The Email label and the value \"([^\"]*)\" is displayed$")
    public void theEmailLabelAndTheValueIsDisplayed(String email)
    {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[4]/div[1]")).getText().equals("Email:"));
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[4]/div[2]"),email);
    }


    @And("^The Address label is displayed$")
    public void theAddressLabelIsDisplayed()
    {
       Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[5]/div[1]")).getText().equals("Adress:"));
    }




    @And("^The value for Address Line One is displayed as \"([^\"]*)\"$")
    public void theValueForAddressLineOneIsDisplayedAs(String addressline1)
    {

        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[5]/div[2]"),addressline1);
    }

    @And("^The value for Address Line Two is displayed as \"([^\"]*)\"$")
    public void theValueForAddressLineTwoIsDisplayedAs(String addressline2)
    {
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[6]/div[2]"),addressline2);
    }

    @And("^The value for Address Line Three is displayed as \"([^\"]*)\"$")
    public void theValueForAddressLineThreeIsDisplayedAs(String addressline3)
    {
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[7]/div[2]"),addressline3);
    }
}
