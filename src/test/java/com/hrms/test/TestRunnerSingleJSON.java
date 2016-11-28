package com.hrms.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber/json/HRMS_ESS_Profile_View.json"},
        features = "D:\\Development\\testing\\hrmstest\\src\\main\\resources\\featurefiles\\HRMS_ESS_Profile_View.feature"
)
/**
 * An example showing how to produce a json output for a single file
 */
public class TestRunnerSingleJSON {
}
