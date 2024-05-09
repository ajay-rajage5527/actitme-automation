package com.AssignmentPractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActitimeChangeStatusPropertyHandling extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPage;
    PropertyHandling propertyHandling;
    @BeforeClass
    public void browserSetup() throws InterruptedException, IOException {
        /* commonFunctions=new CommonFunctions(driver);
        driver =launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
        driver.manage().window().maximize();
        Thread.sleep(5000);*/
        propertyHandling=new PropertyHandling("config.properties");
        String browser=propertyHandling.getProperty("browser");
        String url=propertyHandling.getProperty("url");
        driver=launchBrowser(browser);
        driver.get(url);
        taskPage=new TaskPages(driver);
        commonFunctions=new CommonFunctions(driver);

    }
    @BeforeMethod
    public void beforeMethod(){
       // loginPages.login("rajagea3483@gmail.com","Ajay5527");
       String username= propertyHandling.getProperty("username");
       String password=propertyHandling.getProperty("password");
       loginPages.login(username,password);

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
