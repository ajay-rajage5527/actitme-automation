package com.assignmentpractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExamples extends BaseClass {
    CommonFunctions commonFunctions;
    WebDriver driver;
    TaskPages taskPages;
    LoginPages loginPages;
    @BeforeMethod
    public void beforemethod(){
        commonFunctions=new CommonFunctions(driver);
        driver=launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }
    @Test
    public void alert() throws InterruptedException {

        Thread.sleep(10000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
       // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
       // js.executeScript("arguments[0].scrollIntoView();",searchBox);
        //click operation using javascript
        js.executeScript("arguments[0].click();",searchBox);
        //sendkeys operation
        js.executeScript("arguments[0].value='samsung mobiles';",searchBox);
        WebElement search=driver.findElement(By.id("nav-search-submit-button"));
        js.executeScript("arguments[0].click();",search);//click by js
        //scroll down by uning js
        js.executeScript("window.scrollBy(0,1500);");
    js.executeScript("alert('cyber success');");
    }
}
