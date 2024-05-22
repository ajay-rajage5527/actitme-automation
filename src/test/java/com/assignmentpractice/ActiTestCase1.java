package com.assignmentpractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver =launchBrowser("chrome");
         commonFunctions=new CommonFunctions(driver);
         loginPages=new LoginPages(driver);
        driver.get("https://online.actitime.com/oncospark1");
         taskPage=new TaskPages(driver);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @BeforeMethod
    public void beforeMethod(){
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
        }
    @Test
    public void ChangeTaskStatus() throws Exception {
        Thread.sleep(5000);
        commonFunctions.click(taskPage.taskModule);
        Thread.sleep(3000);
        //commonFunctions.click(taskPage.filghtOperation);
        commonFunctions.click(By.xpath("//div[text()='Flight operation'])[1]"));
        //driver.findElement(By.xpath("//div[text()='Flight operation'])[1]"));
        driver.findElement(By.xpath("//tr[@class='taskRow noLastTrackingDate']/descendant::div[2]")).click();

        driver.findElement(By.xpath("//div[text()='Change Status']")).click();

        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[7]")).click();
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[contains(text(),'Planning')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        String planningStatus =driver.findElement(By.xpath("(//div[text()='Planning'])[1]")).getText();
        String str="Planning";
        if(planningStatus.equals(str)){
            System.out.println("status changed as planning");
        }
        else{
            throw new Exception ("status not changed as planning");
        }
        System.out.println("Ajay1");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
