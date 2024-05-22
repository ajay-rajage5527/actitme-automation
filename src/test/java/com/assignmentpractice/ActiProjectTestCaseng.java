package com.assignmentpractice;

import com.actitime.automation.pages.LoginPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ActiProjectTestCaseng  extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    @BeforeClass
    public void browerSetup() throws InterruptedException {
         commonFunctions=new CommonFunctions(driver);
         driver =launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
    }
    @BeforeMethod
    public void login() throws InterruptedException {
        commonFunctions.loginForActitime(driver);
       // loginPages.login("rajagea3483@gmail.com","Ajay5527");
        Thread.sleep(5000);
        System.out.println("Hello");
    }
    @Test()
    public void createValidProject() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        //click on addd new button
        Thread.sleep(8000);
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        //click on project from dropdown
        //Verify user able to create project with valid data
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        //enter project name
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='sectionDetails']/child::input[1]")).sendKeys("Oncospark ");
        driver.findElement(By.xpath("//div[text()='-- Please Select Customer to Add Project for  --']")).click();
        Thread.sleep(5000);
        //select any customer
        driver.findElement(By.xpath("(//div[text()='Big Bang Company'])[4]")).click();
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        /*for (int i = 0; i < 5; i++) {
            // Send the DOWN arrow key to scroll down
            actions.sendKeys(Keys.DOWN).perform();
        }*/
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(3000);
        //click on create project
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        Thread.sleep(3000);
    }

    //verify user able to create project with invalid name
    @Test
    public void invalidProject() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='sectionDetails']/child::input[1]")).sendKeys("Oncospark123456 ");
        for (int i = 0; i < 5; i++) {
            // Send the DOWN arrow key to scroll down
            Actions obj=new Actions(driver);
            obj.sendKeys(Keys.DOWN).perform();
        }
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        Thread.sleep(3000);

        //Verify user able to create data with invalid data
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='sectionDetails']/child::input[1]")).sendKeys("ONCO@#$%");
        for (int i = 0; i < 5; i++) {
            // Send the DOWN arrow key to scroll down
            Actions obj1=new Actions(driver);
            obj1.sendKeys(Keys.DOWN).perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        Thread.sleep(3000);
    }


    //Empty project name
    @Test
    public void duplicateProject(Actions obj2) throws Exception {
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(3000);
        for (int i = 0; i < 5; i++) {
            // Send the DOWN arrow key to scroll down
            new Actions(driver).sendKeys(Keys.DOWN).perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        String projectName = "Project name cannot be empty";
        String emptyProject = driver.findElement(By.xpath("//div[text()='Project name cannot be empty']")).getText();
    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
