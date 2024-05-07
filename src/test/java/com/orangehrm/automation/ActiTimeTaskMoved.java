package com.orangehrm.automation;

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

public class ActiTimeTaskMoved extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;
    @BeforeClass
    public void setup() throws InterruptedException {
         commonFunctions=new CommonFunctions(driver);
         driver =launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
    }
    @BeforeMethod
    public void login(){
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
    }
    @Test
    public void taskMove() throws InterruptedException {
        commonFunctions.waitForElementClickable(driver.findElement(taskPages.taskModule));
        commonFunctions.click(taskPages.taskModule);
        driver.findElement(By.xpath("(//div[text()='Spaceship building'])[1]")).click();
        Thread.sleep(3000);
        //selected checkbox for task
        WebElement element=driver.findElement(By.xpath("(//div[@class='img'])[1]"));
        element.click();
        //click on move to button
        WebElement moveToButton=driver.findElement(By.xpath("//div[@class='moveTo button'][text()='Move to']"));
        moveToButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='- Select Customer -']")).click();
        Thread.sleep(3000);
        //selected customer from dropdown
        driver.findElement(By.xpath("(//div[text()='Galaxy Corporation'])[2]")).click();
//      select project
        driver.findElement(By.xpath("//div[text()='- Select Project -']")).click();
        //selct project from dropdwon
        driver.findElement(By.xpath("(//div[text()='Android prototyping'])[2]")).click();
        //select move
        driver.findElement(By.xpath("(//div[text()='Move'])[3]")).click();
        String emptytask=driver.findElement(By.xpath("//tr[@class='summary']/descendant::span[1]")).getText();
        String zeroTask="Total for 0 tasks:";
        if(emptytask.equals(zeroTask)){
            System.out.println("Task is successfully moved ");
        }
        else {
            System.out.println("Task is unbale to move");
        }
     }
}
