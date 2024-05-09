package com.AssignmentPractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActiTestCase1 extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPage;
    @BeforeClass
    public void browserSetup() throws InterruptedException {
         commonFunctions=new CommonFunctions(driver);
        driver =launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Hello ");
    }
    @BeforeMethod
    public void beforeMethod(){
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
        }
    @Test
    public void ChangeTaskStatus() throws Exception {
        commonFunctions.waitForElementClickable(driver.findElement(taskPage.taskModule));
        commonFunctions.click(taskPage.taskModule);
        commonFunctions.click(taskPage.filghtOperation);
    Thread.sleep(3000);
        driver.findElement(By.xpath("//tr[@class='taskRow noLastTrackingDate']/descendant::div[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Change Status']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[7]")).click();
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[contains(text(),'Planning')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        String planningStatus =driver.findElement(By.xpath("(//div[text()='Planning'])[1]")).getText();
        String str="Planning";
        System.out.println("hello ,I am Ajay");
        if(planningStatus.equals(str)){
            System.out.println("status changed as planning");
        }
        else{
            throw new Exception ("status not changed as planning");
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
