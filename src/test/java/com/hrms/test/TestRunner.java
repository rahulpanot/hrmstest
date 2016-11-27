package com.hrms.test;

import com.hrms.test.stepdef.HrmsEssProfileTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = "D:\\Development\\testing\\hrmstest\\src\\main\\resources\\featurefiles\\HrmsEssProfileTest.feature"
)
public class TestRunner {
}
