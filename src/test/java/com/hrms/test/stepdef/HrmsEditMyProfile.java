package com.hrms.test.stepdef;

import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rahul on 11/28/2016.
 */
public class HrmsEditMyProfile {
    WebDriver driver;
    HrmsLogin hrmsLogin;
    HrmsEssProfile hrmsEssProfile;
    public HrmsEditMyProfile(HrmsLogin hrmsLogin, HrmsEssProfile hrmsEssProfile) {
        this.driver = Hooks.driver;
        this.hrmsLogin = hrmsLogin;
        this.hrmsEssProfile=hrmsEssProfile;
    }


    @When("^Then the user clicks on edit button$")
    public void the_user_clicks_on_edit_button() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[8]/div[1]/a")).click();
    }


    @And("^The user click on the update button$")
    public void the_user_click_on_the_update_button() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/form/div[8]/div/input[1]")).click();
    }

    @When("^The user clicks on edit button$")
    public void theUserClicksOnEditButton(){
       driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div[8]/div[1]/a")).click();

    }

    @Then("^The user is directed to edit my profile page of \"([^\"]*)\"$")
    public void theUserIsDirectedToEditMyProfilePage(String username) {
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/h2"),"Edit My Profile");
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver,By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/form/div[1]/div"),username);
    }

    @When("^The First Name value \"([^\"]*)\" is entered$")
    public void theFirstNameValueIsEntered(String firstname ) {
        driver.findElement(By.id("profile.firstname")).clear();
        driver.findElement(By.id("profile.firstname")).sendKeys(firstname);
    }

    @And("^The Last Name  value \"([^\"]*)\" is entered$")
    public void theLastNameValueIsEntered(String lastname) {
        driver.findElement(By.id("profile.lastname")).clear();
        driver.findElement(By.id("profile.lastname")).sendKeys(lastname);

    }

    @And("^The Email value \"([^\"]*)\" is entered$")
    public void theEmailValueIsEntered(String email )  {
        driver.findElement(By.id("profile.email")).clear();
        driver.findElement(By.id("profile.email")).sendKeys(email);
    }

    @And("^The value for Address Line one \"([^\"]*)\"is entered$")
    public void theValueForAddressLineOneIsEntered(String addressline1){
        driver.findElement(By.id("profile.addressLine1")).clear();
        driver.findElement(By.id("profile.addressLine1")).sendKeys(addressline1);
    }

    @And("^The value for Address Line Two \"([^\"]*)\"is entered$")
    public void theValueForAddressLineTwoIsEntered(String addressline2)  {
        driver.findElement(By.id("profile.addressLine2")).clear();
        driver.findElement(By.id("profile.addressLine2")).sendKeys(addressline2);
    }

    @And("^The value for Address Line Three \"([^\"]*)\"is entered$")
    public void theValueForAddressLineThreeIsEntered(String addressline3)  {
        driver.findElement(By.id("profile.addressLine3")).clear();
        driver.findElement(By.id("profile.addressLine3")).sendKeys(addressline3);
    }

    @Given("^the user is in the edit profile screen after logging in as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserIsInTheEditProfileScreenAfterLoggingInAsAnd(String username, String password){
        hrmsEssProfile.aUserIsAtTheViewMyProfilePageAfterLoggingInWithAnd(username,password);
        the_user_clicks_on_edit_button();
        theUserIsDirectedToEditMyProfilePage(username);
    }
}