package com.AssignmentPractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import com.orangehrm.automation.LoginPage;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActiTestCase4 extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;
   @BeforeClass
    public void setUp() throws AWTException, InterruptedException {
        commonFunctions=new CommonFunctions(driver);
        taskPages=new TaskPages(driver);
        loginPages=new LoginPages(driver);
       driver.get("https://online.actitime.com/oncospark1");
       driver.manage().window().maximize();
       Thread.sleep(5000);
       Robot rbt=new Robot();
       rbt.keyPress(KeyEvent.VK_CONTROL);
       rbt.keyPress(KeyEvent.VK_MINUS);
       rbt.keyRelease(KeyEvent.VK_MINUS);
       rbt.keyPress(KeyEvent.VK_MINUS);
       rbt.keyRelease(KeyEvent.VK_MINUS);
   }
   @BeforeMethod
    public void beforeclass()
   {
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
   }
   @Test
    public void taskDeletOperation() throws Exception {
       commonFunctions.waitForElementClickable(driver.findElement(taskPages.taskModule));
        commonFunctions.click(taskPages.taskModule);
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[text()='Android testing'])[1]")).click();
        //creation of new task then delete  first task
        driver.findElement(By.xpath("(//div[text()='Add Task'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='taskNamePlaceholder'])[2]/descendant::input")).sendKeys("Task1");
        driver.findElement(By.xpath("(//div[text()='Add Task'])[3]")).click();
        Thread.sleep(5000);
       //creation of new task then delete  second task
       driver.findElement(By.xpath("(//div[text()='Add Task'])[1]")).click();
       driver.findElement(By.xpath("(//div[@class='taskNamePlaceholder'])[2]/descendant::input")).sendKeys("Task2");
       driver.findElement(By.xpath("(//div[text()='Add Task'])[3]")).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("(//div[text()='Add Task'])[1]")).click();
       driver.findElement(By.xpath("(//div[@class='taskNamePlaceholder'])[2]/descendant::input")).sendKeys("Task3");
       driver.findElement(By.xpath("(//div[text()='Add Task'])[3]")).click();
        driver.findElement(By.xpath("//table[@class='headerRowTable']/descendant::div[2]")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//span[text()='Add filters']")).click();
        driver.findElement(By.xpath("(//div[text()='Delete'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='submitTitle buttonTitle'])[3]")).click();
       String getZeroTask=driver.findElement(By.xpath("//span[text()='Total for 0 tasks:']")).getText();
        String str="Total for 0 tasks:";
       /* if(getZeroTask.equals(str)){
            System.out.println("All task succefully deleted and Test Case passed");
        }
        else{
            throw new Exception("All task  not deleted and Test Case get  failed");
        }*/
       Assert.assertEquals(getZeroTask,str,"All task succefully deleted and Test Case passed");
   }
}
