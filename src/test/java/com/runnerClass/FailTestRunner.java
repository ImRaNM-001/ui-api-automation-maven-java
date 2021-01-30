package com.runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"@target/failedrerun.txt"},
        glue = {"com.stepDefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "rerun:target/failedrerun.txt",     // makes entry of any failed scenario in this file
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish = true
)

public class FailTestRunner extends AbstractTestNGCucumberTests{}


// this class will execute failed scenarios captured as line numbers in "failedrerun.txt" file but if we fixed the
// issue, the entry of scenario line numbers in "failedrerun.txt" will vanish and nothing will execute
