//package com.hooks;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class ScenarioHooks {
//
//    private WebDriver driver;
//
//    @After
//    public void tearDown(Scenario scenario){
//        if(scenario.isFailed() ){
//            String fileName = scenario.getName().replaceAll(" ", "_");
//            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);    // it will give null
//            // pointer exception
//            scenario.attach(sourcePath, "img/png", fileName);
//        }
//    }
//
//}
