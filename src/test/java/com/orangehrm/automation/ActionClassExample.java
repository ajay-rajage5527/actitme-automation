package com.orangehrm.automation;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClassExample extends BaseClass {
    CommonFunctions commonFunctions;
    WebDriver driver;
    LoginPages loginPages;
    TaskPages taskPages;

    @BeforeClass

    public void setup(){
        commonFunctions=new CommonFunctions(driver);
        driver=launchBrowser("chrome");
        loginPages=new LoginPages(driver);
        taskPages=new TaskPages(driver);
        driver.get("https://online.actitime.com/oncospark1");
    }
    @Test
    public void test(){
        Actions actions=new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("username")),"rajagea3483@gmail.com").build().perform();
        actions.click(driver.findElement(By.name("pwd"))).sendKeys("Ajay5527").build().perform();
        actions.moveToElement(driver.findElement(By.id("loginButton"))).click().build().perform();
        // if want to click on loginButton we can use contextClick();
        // actions.contextClick(driver.findElement(By.id("loginButton"))).build().perform();
        WebElement link=driver.findElement(By.partialLinkText("actitime"));
        actions.contextClick(link).build().perform();
        //press downward arrow
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        //want to realease key
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        //wanna enter button on keyboard
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();
        //wanna scroll
        //actions.scrollByAmount(-100,0);
        //actions.scrollByAmount(0,500);
        //actions.scrollToElement(WebElement).build().perform();

    }
}



