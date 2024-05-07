package com.AssignmentPractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActiUsersTestCase7 extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;
    @BeforeClass
    public void setup() throws InterruptedException, AWTException {
        commonFunctions = new CommonFunctions(driver);
        taskPages=new TaskPages(driver);
        loginPages=new LoginPages(driver);
        driver = launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
        driver.manage().window().maximize();
        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_MINUS);
        rbt.keyRelease(KeyEvent.VK_MINUS);
        rbt.keyPress(KeyEvent.VK_MINUS);
        rbt.keyRelease(KeyEvent.VK_MINUS);
        Thread.sleep(5000);
    }
@BeforeMethod
public void beforeMethod(){
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
}
    @Test
    public void usersCreation() throws InterruptedException {
        commonFunctions.waitForElementClickable(driver.findElement(taskPages.taskModule));
        commonFunctions.click(taskPages.taskModule);
        commonFunctions.waitForElementClickable(driver.findElement(taskPages.filghtOperation));
         driver.findElement(By.xpath("//table[@class='headerRowTable']/descendant::div[2]")).click();
       driver.findElement(By.xpath("//span[text()='Add filters']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h3[text()='Configure Filters']/following::span[4]/child::*")).click();
       driver.findElement(By.xpath("//div[text()='Apply']")).click();
        WebElement assign =driver.findElement(By.xpath("//div[text()='Assign to']"));
        commonFunctions.waitForElementClickable(assign);
        assign.click();
       /* driver.findElement(By.xpath("//div[@class='components-DataFilters-text--V3cbC8fc']")).click();
       driver.findElement(By.xpath("(//label[@class='components-RadioButton-radio--gYT9bhsE'])/following::input[1]")).click();
       driver.findElement(By.xpath("(//label[@class='components-RadioButton-radio--gYT9bhsE'])/following::span//child::span")).click();
       driver.findElement(By.xpath("//div[text()='Apply']")).click();*/
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tr[@id='ext-gen43']/following::td[3]")).click();
        driver.findElement(By.xpath("(//div[@class='childrenContainer'])[3]/descendant::span[1]")).click();
        driver.findElement(By.xpath("//span[text()='Assign']")).click();
    }
}