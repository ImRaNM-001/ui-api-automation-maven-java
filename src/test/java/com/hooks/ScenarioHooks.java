package com.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;

public class ScenarioHooks {

//    private WebDriver driver;

    // hook to skip a scenario from cucumber
    @Before(value = "@Skip", order = 0)
    public void skipScenario(Scenario scenario) {
        System.out.println("Skipped scenario is " + scenario.getName() );
        Assume.assumeTrue(false);       // this line acts as @Test(enabled=false)
    }


   /* @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String fileName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);    // it will give null
            // pointer exception
            scenario.attach(sourcePath, "img/png", fileName);
        }
    }       */

}
