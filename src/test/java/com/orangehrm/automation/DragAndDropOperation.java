package com.orangehrm.automation;

import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropOperation extends BaseClass {
    CommonFunctions commonFunctions;
    WebDriver driver;
    @BeforeClass
    public void setup(){
         commonFunctions = new CommonFunctions(driver);
         driver = launchBrowser("chrome");
        driver.get("https:globalsqa.com/demo-site/draganddrop/");
    }
@Test
public void test(){
    WebElement iframeElement=driver.findElement(By.xpath("iframe[@class='demo-frame lazyloaded']"));
    driver.switchTo().frame(iframeElement);
    Actions actions=new Actions(driver);
    WebElement srcElement=driver.findElement(By.xpath("//u[@id='gallary'/li[1]/img"));
    WebElement dstElement=driver.findElement(By.id("trash"));
    actions.dragAndDrop(srcElement,dstElement).build().perform();
    // actions.clickAndHold(srcElement).release(dstElement).build().perform();
    // actions.doubleClick(srcElement).build().perform();
    //move control back to main page
    driver.switchTo().defaultContent();

    // print title of page
    String title=driver.getTitle();
    System.out.println(title);
}
}

