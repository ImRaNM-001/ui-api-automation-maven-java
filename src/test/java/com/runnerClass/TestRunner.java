package com.runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import org.junit.runner.RunWith;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

// 1> run with junit runner
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/main/resources/Features",
//        glue = {"com.stepDefinitions", "TestRunner"},
//        tags = "@Smoke",
//        plugin = {"pretty",
//                "html:target/CucumberReports/cucumber-report.html",
//                "json:target/CucumberReports/cucumber-report.json"},
//        publish = true,
//        dryRun = true
//
//        )
//public class TestRunner{}

// 2> run with testng runner (without junit)
@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"com.stepDefinitions", "com.hooks"},      // required when we need to include hooks java code
//        glue = {"com.stepDefinitions"},
//        tags = "@All",                           // do not use {} like tags = {"~@Smoke"} in cucumber 6 else it would throw error
//        tags = "@Billing or @Registration or @Lonely",
//        tags = "@Billing or @Registration and not @Skip",
//        tags = "@Billing or @Registration and not @Skip or @Lonely and not @Skip",
//        tags = "not @Skip",
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "rerun:target/failedrerun.txt",     // makes entry of any failed scenario in this file
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//        plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty.html"},
//        strict = true,
//        monochrome = true,
        publish = true,
        dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests{}

    /*      below logic are not required as these are already included in the above abstract class AbstractTestNGCucumberTests

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "featureCount")
    public void someFeature(CucumberFeatureWrapper cucumberFeatureWrapper) {
        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] featureCount(){
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void tearDown() throws Exception{
        testNGCucumberRunner.finish();
    }           */




