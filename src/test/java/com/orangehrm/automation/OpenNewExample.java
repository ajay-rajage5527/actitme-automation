package com.orangehrm.automation;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenNewExample extends BaseClass {
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = launchBrowser("chrome");
        commonFunctions = new CommonFunctions(driver);
        loginPages = new LoginPages(driver);
        taskPages = new TaskPages(driver); // Initialize taskPages object
        driver.get("https://online.actitime.com/oncospark1");
    }

    @BeforeMethod
    public void login(){
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
    }
@Test
public void test(){
        commonFunctions.waitForElementToPresent(driver,driver.findElement(taskPages.taskModule));
      // commonFunctions.click(taskPages.taskModule);
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();",taskPages.taskModule);

}
}

