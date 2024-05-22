package com.assignmentpractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActtimeUserAssignment extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;
    @BeforeClass
    public void setUp() throws InterruptedException, AWTException {
        commonFunctions = new CommonFunctions(driver);
        taskPages=new TaskPages(driver);
        loginPages=new LoginPages(driver);
        driver =launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
    }

    @BeforeMethod
    public void loginActitime() throws AWTException, InterruptedException {
      loginPages.login("rajagea3483@gmail.com","Ajay5527");
        driver.manage().window().maximize();
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_MINUS);
        rbt.keyRelease(KeyEvent.VK_MINUS);
        rbt.keyPress(KeyEvent.VK_MINUS);
        rbt.keyRelease(KeyEvent.VK_MINUS);
    }

    @Test
    public void usersModule() throws Exception {
        driver.findElement(By.xpath("//div[text()='Users']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("(//span[text()='All Users'])[1]")).click();
        driver.findElement(By.xpath("(//img[@class='x-form-radio'])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[text()='Meyers, Allison'])[2]")).click();
        driver.findElement(By.xpath("(//span[text()='Apply'])[2]")).click();
        Thread.sleep(5000);
        WebElement mayerText= driver.findElement(By.xpath("(//span[text()='Meyers, Allison'])[1]"));
        mayerText.click();
        String text1=mayerText.getText();
        if(text1.equals("Meyers, Allison")){
            System.out.println("User is successfully created");
        }
        else {
            throw new Exception("user unbale to create successfully ");
        }
        Thread.sleep(8000);
        Actions actions = new Actions(driver);
        WebElement text = driver.findElement(By.xpath("(//div[@class='regularRateColumn'])[1]/descendant::input"));
        actions.scrollToElement(text).build().perform();
        actions.click(text);
        Thread.sleep(5000);
        actions.keyDown(Keys.BACK_SPACE);
        driver.findElement(By.xpath("(//div[@class='regularRateColumn'])[1]/descendant::input")).sendKeys("500");
        driver.findElement(By.xpath("(//div[@class='hideButton_panelContainer'])[1]")).click();

    }
}