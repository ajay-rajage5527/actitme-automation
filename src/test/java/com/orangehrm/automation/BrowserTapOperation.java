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

import java.util.Set;

public class BrowserTapOperation extends BaseClass {
    CommonFunctions commonFunctions;
    WebDriver driver;

    @BeforeClass
    public void setup(){
         commonFunctions=new CommonFunctions(driver);
         driver=launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark");
    }
    @Test
    public void test(){
        WebElement actiTimeLink =driver.findElement(By.partialLinkText("actiTIME"));
        Actions actions=new Actions(driver);
        actions.contextClick(actiTimeLink).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ENTER).build().perform();
        System.out.println(driver.getTitle());
        //get current tab id
        String LoginWindowID=driver.getWindowHandle();
        System.out.println(LoginWindowID);
        //get all windows id
        Set<String> allWindowsId= driver.getWindowHandles();
        System.out.println(allWindowsId);

        //iterate through set and check loginWindowID
        for(String id :allWindowsId){
            if(!id.equals(LoginWindowID))
            {
                System.out.println("Second Tap"+id);
                driver.switchTo().window(id);
                System.out.println(driver.getTitle());
                driver.close();
                //move control back to main page
                driver.switchTo().window(LoginWindowID);
                System.out.println(driver.getTitle());
            }
        }

    }
}


