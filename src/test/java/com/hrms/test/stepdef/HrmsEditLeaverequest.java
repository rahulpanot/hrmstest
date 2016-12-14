package com.hrms.test.stepdef;

import com.hrms.test.utils.Hooks;
import com.hrms.test.utils.WebDriverUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by rahul on 12/3/2016.
 */
public class HrmsEditLeaverequest {
    private WebDriver driver;

    public HrmsEditLeaverequest() {
        this.driver = Hooks.driver;
    }

    @When("^the user click on leaves$")
    public void theUserClickOnLeaves()
    {
        driver.findElement(By.id("ess_myleaves")).click();
    }

    @Then("^the user is directed to my leaves screen of \"([^\"]*)\"$")
    public void theUserIsDirectedToMyLeavesScreenOf(String Myleaves) {
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver, By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/h2"), "My leaves");

    }

    @And("^the user click on create new leave request$")
    public void theUserClickOnCreateNewLeaveRequest() {
        driver.findElement(By.id("createNewLeaveRequestBtn")).click();

    }

    @And("^the leave details display on the screen$")
    public void theLeaveDetailsDisplayOnTheScreen(String LeaveDetails) {
        WebDriverUtil.checkWithWaitIfElementTextValueIs(driver, By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]"), "Leave Details");

    }

    @And("^Select the leave type in dropdown button$")
    public void selectTheLeaveTypeInDropdownButton()  {
        WebElement Select = driver.findElement(By.id("Leave Type"));
        List<WebElement> options=Select.findElements(By.tagName("Annual Leave,Sick Leave,Childcare Leave,FamilyCare Leave"));
        for (WebElement option:options){
            if ("Annual Leave".equals(option.getText()));
            option.click();
        }

        }
    }



