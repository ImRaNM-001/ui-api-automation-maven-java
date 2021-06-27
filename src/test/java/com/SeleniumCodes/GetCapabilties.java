package com.SeleniumCodes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class GetCapabilties {

    private ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void getAllCapabilities(){
        Capabilities cap = driver.getCapabilities();    // getCapabilities() mtd is only available in child class RemoteWebDriver (not in interface WebDriver)

        // storing the <K,V> in a map
        var myMap = cap.asMap();        // var helped inferring Map<String, Object>
        System.out.println(myMap);
        System.out.println("Printing capabilities in <Key,Value> pair as follows================>>\n");

        // iterate Map (var also works inplace of Entry<String, Object> )
        for(Entry<String, Object> et : myMap.entrySet() )
            System.out.println("key is: " + et.getKey() + "value is: " + et.getValue() );
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
