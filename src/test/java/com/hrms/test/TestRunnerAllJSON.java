package com.hrms.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber/json/"},
        features = "D:\\Development\\testing\\hrmstest\\src\\main\\resources\\featurefiles"
)
/**
 * Example showing how to generate json results for all the feature files in a directory
 */

public class TestRunnerAllJSON {
}
