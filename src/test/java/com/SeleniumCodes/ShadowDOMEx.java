package com.SeleniumCodes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShadowDOMEx {

    private WebDriver driver;                   // important lesson learnt before instantiating driver never typecast to JavascriptExecutor

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void pointsVilleLogin() throws InterruptedException {
        driver.get("http://sandbox-sponsors.pointsville.com/");
        //Thread.sleep(5000);

         JavascriptExecutor js = (JavascriptExecutor) driver;

         // extracted username element from shadow root
         WebElement userName = (WebElement) js.executeScript("return document.querySelector('amplify-authenticator" +
                " > amplify-sign-in').shadowRoot.querySelector('amplify-form-section > amplify-auth-fields').shadowRoot.querySelector('div > amplify-username-field').shadowRoot.querySelector('amplify-form-field').shadowRoot.querySelector('input')");

        // extracted password element from shadow root
         WebElement passWord = (WebElement) js.executeScript("return document.querySelector(\"amplify-authenticator >" +
                 " amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\")" +
                 ".shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password\")");

        // extracted forgot password link element from shadow root
         WebElement resetPwdLink = (WebElement) js.executeScript("return  document.querySelector(\"amplify-authenticator > amplify-sign-in\").shadowRoot.querySelector(\"amplify-form-section > amplify-auth-fields\").shadowRoot.querySelector(\"div > amplify-password-field\").shadowRoot.querySelector(\"amplify-form-field\").shadowRoot.querySelector(\"#password-hint > div > amplify-button\")");


//    String valueByJS = "arguments[0].setAttribute('value', 'Watching Movie')";        // naveen way of storing the javascript execution on String first (hard way) for me
//        js.executeScript(valueByJS, userName);

        js.executeScript("arguments[0].value='Watching Movie'", userName);              // mukesh's way (easy way) for me
        //Thread.sleep(3000);

//        js.executeScript(valueByJS, passWord);
        js.executeScript("arguments[0].value='Watching Movie'", passWord);              // mukesh's way (easy way) for me
        //Thread.sleep(3000);

        js.executeScript("arguments[0].click()", resetPwdLink);                // naveen wrote "arguments[0].click();"      with a semi-colon at end but the one I wrote also works fine
        //Thread.sleep(3000);
    }
//  jijgar  dscds
    @Test
    public void chromeDownloads() throws InterruptedException {
        driver.get("chrome://downloads/");
        //Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // extracted search element of Chrome Downloads window from shadow root
        WebElement searchBtn = (WebElement) js.executeScript("return document.querySelector(\"downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");

        js.executeScript("arguments[0].value='I succeeded in sending text to Downloads search button'", searchBtn);                 // sending keys to search button of Chrome Downloads
        //Thread.sleep(3000);
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
