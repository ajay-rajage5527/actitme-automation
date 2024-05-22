package com.assignmentpractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActiTimeTestCaseOnProject extends BaseClass {
CommonFunctions commonFunctions;
TaskPages taskPages;
LoginPages loginPages;
WebDriver driver;
    @BeforeClass
    public void beforeclass(){
        commonFunctions = new CommonFunctions(driver);
        driver =launchBrowser("chrome");
        loginPages=new LoginPages(driver);
        taskPages=new TaskPages(driver);
        driver.get("https://online.actitime.com/oncospark1");
    }
    @BeforeMethod
    public void beforeMethod(){
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
    }

    @Test
    public void testmethod() throws Exception {
        commonFunctions.waitForElementClickable(driver.findElement(taskPages.taskModule));
        commonFunctions.click(taskPages.taskModule);
        //click on addd new button
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        //click on project from dropdown
        //Verify user able to create project with valid data
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        //enter project name
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='sectionDetails']/child::input[1]")).sendKeys("Oncospark ");
        driver.findElement(By.xpath("//div[text()='-- Please Select Customer to Add Project for  --']")).click();
        Thread.sleep(3000);
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

        //Verify user able to create data with invalid data
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='sectionDetails']/child::input[1]")).sendKeys("Oncospark123456 ");
        for (int i = 0; i < 5; i++) {
            // Send the DOWN arrow key to scroll down
            actions.sendKeys(Keys.DOWN).perform();
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
            actions.sendKeys(Keys.DOWN).perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        Thread.sleep(3000);

        //verify user able to create project without entering project name in field
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(3000);
        for (int i = 0; i < 5; i++) {
            // Send the DOWN arrow key to scroll down
            actions.sendKeys(Keys.DOWN).perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        String projectName = "Project name cannot be empty";
        String emptyProject = driver.findElement(By.xpath("//div[text()='Project name cannot be empty']")).getText();
        if (emptyProject.equals(projectName)) {
            System.out.println("Test case passed for empty project name");
        } else {
            throw new Exception("Test case failed for empty project name");
        }


        //verify user able to create duplicate project name
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='sectionDetails']/input[1]")).sendKeys("ONCO@#$%");
        for (int i = 0; i < 5; i++) {
            // Send the DOWN arrow key to scroll down
            actions.sendKeys(Keys.DOWN).perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        String duplicateProject=driver.findElement(By.xpath("//div[@class='projectNameErrorWrapper']/child::div[1]")).getText();
        String dupliProject="Customer already contains a project with the specified name";
        if(dupliProject.equals(dupliProject)){
            System.out.println("Test case is passed for duplicate project");
        }
        else{
            throw new Exception("Test case is failed for duplicate ");
        }

    }
    }

