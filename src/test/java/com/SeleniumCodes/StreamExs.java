package com.SeleniumCodes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StreamExs {

    private WebDriver driver;

    @BeforeMethod
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void findAmazonLinks() {
        driver.get("https://www.amazon.in/");
        List<WebElement> amazonLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links in the page " + amazonLinks.size());

        // action1 - using Enhanced for loop to get all the text of the links
        for (WebElement elem : amazonLinks) System.out.println(elem.getText());

        // action2 using internal for loop to get all the text of the links
        amazonLinks.forEach(elem -> System.out.println(elem.getText()));
        amazonLinks.stream().forEach(elem -> System.out.println(elem.getText()));      // JVM shows message "The
        // stream().forEach()' chain can be replaced with 'forEach()' (may change semantics)"

        amazonLinks.forEach(System.out::println);       // another way of printing local variable elem like amazonLinks.forEach(elem -> System.out.println(elem) );

        // action 3 - printing the 1st text
        String firstText = amazonLinks.stream()
                .filter(elem -> !elem.getText().equals(""))
                .findFirst().get().getText();

        System.out.println(firstText);

        // action 4 - printing any text
        String anyText = amazonLinks.stream()
                .filter(elem -> !elem.getText().equals(""))
                .findAny().get().getText();

        System.out.println(anyText);

        // action 5 - printing text of all links without blanks containing text "Amazon"
        List<String> nonEmptyLinksAmazonText = amazonLinks.stream()
                .filter(elem -> !elem.getText().equals("") && elem.getText().contains("Amazon"))       // using && we can avoid 2 .filter() statements
                .map(elem -> elem.getText())            // this line can also be written as .map (WebElement::getText)
                .collect(Collectors.toList());

//        nonEmptyLinksAmazonText.forEach(elem -> System.out.println(elem) );
        nonEmptyLinksAmazonText.forEach(System.out::println);

        // action 6 - printing text of all links without blanks
        List<String> nonEmptyLinksText = amazonLinks.stream()
                .filter(elem -> !elem.getText().isEmpty() && elem.getText().startsWith(""))
                .map(elem -> elem.getText().trim())
                .collect(Collectors.toList());

        nonEmptyLinksText.forEach(System.out::println);
    }


    @Test
    public void clickAllLinks() {
        driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

        // hitting the page size dropdown and selecting page no as 50
        WebElement dropdownElement = driver.findElement(By.name("example_length"));
        Select se = new Select(dropdownElement);
        se.selectByVisibleText("50");

//        List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("td.select-checkbox"));
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//td[@class=' select-checkbox']"));       // try this xpath as well it works

        // click on all checkboxes
        allCheckBoxes.forEach(elem -> elem.click());
    }

    @Test
    public void getFreshworksLinks() {
        driver.get("https://www.freshworks.com/");

        // action 1 - capturing all footer links in a List and printing text of each links
        List<WebElement> footerLinks = driver.findElements(By.cssSelector("ul.footer-nav>li"));
//        footerLinks.forEach(elem -> System.out.println(elem.getText()) );

        // action 2 - capturing all footer links in a List, storing it's text into a new ArrayList and then use stream() to print each text from that 2nd ArrayList
        List<String> newFooterList = new ArrayList<>();         // since we are storing the Text of each links and not the WebElement
        footerLinks.forEach(elem -> newFooterList.add(elem.getText()));

        // printing the text in new ArrayList
        newFooterList.forEach(System.out::println);
    }


    @Test
    public void getJavaScriptPopupTitle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Entry Ad")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String mainWindowTitle = js.executeScript("return document.title").toString(),        // prints window title of main page not popup
                popupTitle = js.executeScript("return document.querySelector('div.modal-title>h3').innerHTML").toString(),        // prints the Javascript popup title
                popupText = js.executeScript("return document.querySelector('div.modal-body').innerHTML").toString();         // prints text present inside the popup

        System.out.println(mainWindowTitle);
        System.out.println(popupTitle);
        System.out.println(popupText);

    }


    @Test
    public void getPopupTitle() throws InterruptedException {
        driver.get("https://blazemeter.com/");                 // the URL used by Naveen no longer up & running, hence used different URL
        driver.findElement(By.linkText("Request a Demo")).click();

        // way 1 - using traditional Set Collection
  /*      Set<String> handles = driver.getWindowHandles();
        System.out.println("Total no. of window tabs opened are " + handles.size() );

        Iterator<String> itr = handles.iterator();
        while(itr.hasNext() ){
            String mainWindow = itr.next(),
                childWindow = itr.next();
            driver.switchTo().window(childWindow);
            System.out.println("The title of page opened in new tab is " + driver.getTitle() );
            Thread.sleep(3000);
//            driver.close();

//            driver.switchTo().defaultContent();             // doesn't work for window handles, may work for frames (try it out later)
            driver.switchTo().window(mainWindow);
            Thread.sleep(3000);
        }                             */

        // way 2 - using Java8 Lambda's and Stream methods
        String childWindowTitle = switchToPopup(driver, "sting Challenges");
        driver.close();
        Thread.sleep(2000);
        System.out.println("The title of 2nd window is " + childWindowTitle);
    }


    public String switchToPopup(WebDriver driver, String title) {
        Set<String> handles = driver.getWindowHandles();

        return handles.stream()                                                 // this is returning a String named poupTitle interally
                .map(popup -> driver.switchTo().window(popup).getTitle())
                .filter(elem -> elem.contains(title))
//               .filter(elem -> elem.equalsIgnoreCase(title))
//                .filter(elem -> elem.contains(title) || elem.equalsIgnoreCase(title))     // .contains() and
//                equalsIgnoreCase() doe not work together, need to use org.apache.commons.lang3.StringUtils
//                .containsIgnoreCase("AbBaCca", "bac"); but driver.getWindowHandles(); do not return Set<StringUtils>

                .findAny()
                .orElseThrow(() -> {
                    throw new RuntimeException("No such pop up here...");       // without {} braces exception doesn't work
                });             // return statement closed
    }           // method closed


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
