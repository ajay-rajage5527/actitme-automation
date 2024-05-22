package com.assignmentpractice;

import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenImagesNg  extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    @BeforeClass
    public void SetUp(){
         commonFunctions=new CommonFunctions(driver);
        driver =launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
    }
    @Test
    public void brokenImages() throws IOException {
        List<WebElement> webElements = driver.findElements(By.tagName("img"));
        for (WebElement element : webElements) {
            String link = element.getAttribute("src");
            //System.out.println(link);
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            HttpsURLConnection urlConnection = (HttpsURLConnection) connection;
            urlConnection.connect();
            int statusCode = urlConnection.getResponseCode();
            if (statusCode != 200) {
                System.out.println("Broken Images" + statusCode + " " + link);
            } else {
                System.out.println(" no Broken Images");
            }
        }
    }
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}

