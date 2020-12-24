package com.SeleniumCodes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownHandle {

    private WebDriver driver;
    private By industry = By.id("Form_submitForm_Industry");
    private By country = By.id("Form_submitForm_Country");

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
    }

    @Test
    public void selectDropdown() throws InterruptedException {

        selectDropdownValue(country, DropdownValues.INDEX.toString(), "5");
        //Thread.sleep(2000);

        selectDropdownValue(industry, DropdownValues.VISIBLETEXT.toString(), "Education");
        //Thread.sleep(2000);

        selectDropdownValue(country, DropdownValues.VALUE.toString(), "India");
        //Thread.sleep(2000);

        selectDropdownValue(industry, DropdownValues.VALUE.toString(), "health");
        //Thread.sleep(2000);

    }

    public void selectDropdownValue(By locator, String type, String value) {
        Select select = new Select(getElement(locator) );

        switch (type) {
            case "index":
                select.selectByIndex(Integer.parseInt(value) );
                break;

            case "value":
                select.selectByValue(value);
                break;

            case "visibletext":
                select.selectByVisibleText(value);
                break;

            default:
                System.out.println("Pass the correct selection criteria");
                break;
        }
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
