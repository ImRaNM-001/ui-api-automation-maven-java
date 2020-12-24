package com.runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features/RegistrationDataTbl.feature",
        glue = {"com.stepDefinitions"},
        tags = "@All",
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "rerun:target/rerun.txt"},
        publish = true,
        dryRun = false
)

public class RegistrationDataTestRunner extends AbstractTestNGCucumberTests{}