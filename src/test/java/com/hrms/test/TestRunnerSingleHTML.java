package com.hrms.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/html"},
        features = "D:\\Development\\testing\\hrmstest\\src\\main\\resources\\featurefiles\\HRMS_ESS_Profile_View.feature"
)
public class TestRunnerSingleHTML {
}
