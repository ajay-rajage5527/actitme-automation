package com.orangehrm.automation;

import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class AmazonAssignment extends BaseClass {
    CommonFunctions commonFunctions;
    WebDriver driver;
    @BeforeClass
    public void setup(){
        commonFunctions=new CommonFunctions(driver);
        driver=launchBrowser("chrome");
        driver.get("https://www.amazon.in");
    }
       @Test
           public void test() throws AWTException {
           Robot robot=new Robot();
           driver.findElement(By.xpath("//a[text()='Amazon miniTV']")).click();
         // actions.sendKeys(Keys.ARROW_DOWN).build().perform();
           //actions.keyUp(Keys.ARROW_DOWN).build().perform();
           // actions.sendKeys(Keys.ENTER).build().perform();
           // Robot robot=new Robot();
           //robot.keyPress(KeyEvent.VK_PAGE_DOWN);
           // robot.keyPress(KeyEvent.VK_PAGE_DOWN);
           //  actions.keyDown(Keys.ENTER);
       }
       }
               // driver.manage().window().maximize();


