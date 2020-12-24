//package com.stepDefinitions;
//
//import com.SeleniumCodes.DropdownHandle;
//import com.SeleniumCodes.DropdownValues;
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.messages.Messages;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//
//import java.util.concurrent.TimeUnit;
//
//public class OrangeDropdownSteps {                  // this coding style is horrible, avoid it all cost (I just did
//    // for checking failed screenshots getting attached to maven cucumber reporting
//
//    private WebDriver driver;
//    private By industry = By.id("Form_submitForm_Industry");
//    private By country = By.id("Form_submitForm_Country");
//
//    DropdownHandle dHandle;
//
//    @Given("^user gets into orange hrm site$")
//    public void user_gets_into_orange_hrm_site() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//    }
//
//    @When("^user makes different selection in industry and country dropdown$")
//    public void user_makes_different_selection_in_industry_and_country_dropdown() throws InterruptedException {
//        selectDropdownValue(country, DropdownValues.INDEX.toString(), "5");
//        //Thread.sleep(2000);
//
//        selectDropdownValue(industry, DropdownValues.VISIBLETEXT.toString(), "Education");
//        //Thread.sleep(2000);
//
//        selectDropdownValue(country, DropdownValues.VALUE.toString(), "India");
//        //Thread.sleep(2000);
//
//        selectDropdownValue(industry, DropdownValues.VALUE.toString(), "health1");
//    }
//
//
//    public void selectDropdownValue(By locator, String type, String value) {
//        Select select = new Select(getElement(locator) );
//
//        switch (type) {
//            case "index":
//                select.selectByIndex(Integer.parseInt(value) );
//                break;
//
//            case "value":
//                select.selectByValue(value);
//                break;
//
//            case "visibletext":
//                select.selectByVisibleText(value);
//                break;
//
//            default:
//                System.out.println("Pass the correct selection criteria");
//                break;
//        }
//    }
//
//    public WebElement getElement(By locator) {
//        return driver.findElement(locator);
//    }
//
//
//    @Then("^test is successful$")
//    public void test_is_successful(){
//        System.out.println("Tested Ok");
////        Assert.assertTrue(false);
//    }
//
//    @After(order=1)
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            String fileName = scenario.getName().replaceAll(" ", "_");
//            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);    // it will give null
//            // pointer exception
//            scenario.attach(sourcePath, "img/png", fileName);
//        }
//    }
//
//    @After(order=0)
//    public void closeBrowser(){
//        driver.close();
//    }
//}
