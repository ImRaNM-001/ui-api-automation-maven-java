package com.SeleniumCodes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExecuteTestsOnExistingSession {

    /*
     *   use case1: TC has 100 steps - 98 steps passed but 2 steps failed, we use existing session to execute remaining cases instead of starting from beginning all over again
     *
     *   use case2: some additional methods or new things/implementation on already opened session without starting a new one
     *
     *   command: chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\testAutomationPractice\installationArea\chromeSessionData"
     *
     * */

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9222");     // key "debuggerAddress" is mandatory

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void runTestOnExistingSession() {
        // below code borrowed from StreamExs.java getFreshworksLinks() mtd

        // part1: run below code by commenting part2 so to see the effect
        driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

        // hitting the page size dropdown and selecting page no as 50
        WebElement dropdownElement = driver.findElement(By.name("example_length"));
        Select se = new Select(dropdownElement);
        se.selectByVisibleText("50");


        // part2: run below code by commenting part1 so to see the effect
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//td[@class=' select-checkbox']") );
        // click on all checkboxes
        allCheckBoxes.forEach(elem -> elem.click() );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
