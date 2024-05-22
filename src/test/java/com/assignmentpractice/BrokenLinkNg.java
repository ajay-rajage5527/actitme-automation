package com.assignmentpractice;

import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinkNg  extends BaseClass {
    static WebDriver driver;
    CommonFunctions commonFunctions;

    @BeforeTest
    public void setUp() {
         commonFunctions = new CommonFunctions(driver);
        driver = launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
    }
    @Test
    public void selectBrokenLinks() throws IOException {
        List<WebElement> webElements = driver.findElements(By.tagName("a"));
        for (WebElement element : webElements) {
            String link = element.getAttribute("href");
            if (link != null && !link.startsWith("javascript")) {
                URL url = new URL(link);
                URLConnection connection = url.openConnection();
                HttpURLConnection urlConnection = (HttpURLConnection) connection;
                urlConnection.connect();
                int statusCode = urlConnection.getResponseCode();
                if (statusCode == 200) {
                    System.out.println("Broken Links: " + statusCode + " " + link);
                }
            }

        }
    }
              @AfterTest
           public void tearDown(){
           driver.quit();
    }
}