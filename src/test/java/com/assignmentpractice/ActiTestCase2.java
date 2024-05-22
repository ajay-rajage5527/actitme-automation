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

public class ActiTestCase2 extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;
    @BeforeClass
    public void beforeClass() throws InterruptedException {
   driver=launchBrowser("chrome");
   commonFunctions=new CommonFunctions(driver);
   taskPages=new TaskPages(driver);
   loginPages=new LoginPages(driver);
    driver.get("https://online.actitime.com/oncospark1");
}
@BeforeMethod
public void beforeMethod(){
          loginPages.login("rajagea3483@gmail.com","Ajay5527");
        }

@Test
    public void copyTask() throws InterruptedException {
        commonFunctions.waitForElementClickable(driver.findElement(taskPages.taskModule));
        // driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        commonFunctions.click(taskPages.taskModule);

         //driver.findElement(By.xpath("(//div[text()='My Practice Task'])[1]")).click();
        commonFunctions.click(taskPages.mypracticeproject);

         driver.findElement(By.xpath("//table[@class='headerRowTable']/descendant::div[2]")).click();

         driver.findElement(By.xpath("(//div[text()='Copy to'])[1]")).click();

         driver.findElement(By.xpath("//div[text()='- Select Customer -']")).click();

         //driver.findElement(By.xpath("(//div[text()='Galaxy Corporation'])[2]")).click();
         commonFunctions.click(taskPages.galaxyCorporation);

         driver.findElement(By.xpath("//div[text()='- Select Project -']")).click();
         driver.findElement(By.xpath("(//div[text()='Android prototyping'])[2]")).click();

         driver.findElement(By.xpath("(//div[text()='Copy'])[4]")).click();

     }
     @AfterClass
    public void tearDown(){
        driver.quit();
     }
}
