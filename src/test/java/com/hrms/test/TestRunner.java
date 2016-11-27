package com.hrms.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = "D:\\development\\hrmstest\\src\\main\\resources\\featurefiles"
)
public class TestRunner {
}
