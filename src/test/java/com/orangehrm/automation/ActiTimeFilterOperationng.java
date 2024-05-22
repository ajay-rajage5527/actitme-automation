package com.orangehrm.automation;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActiTimeFilterOperationng  extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;
    @BeforeClass
    public void setup() throws InterruptedException {
         commonFunctions = new CommonFunctions(driver);
         loginPages=new LoginPages(driver);
         taskPages=new TaskPages(driver);
         driver = launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
        Thread.sleep(5000);
    }
    @Test
    public void filterTasks() throws Exception {

        commonFunctions.waitForElementClickable(driver.findElement(taskPages.taskModule));
        commonFunctions.click(driver.findElement(taskPages.taskModule));

        // Select project (Flight operations in this case)
        driver.findElement(By.xpath("(//div[text()='Flight operations'])[1]")).click();

        // Select checkbox for the task
        Thread.sleep(3000);
        WebElement taskCheckbox = driver.findElement(By.xpath("(//div[@class='img'])[1]"));
        taskCheckbox.click();

        // Open change status dialog
        driver.findElement(By.xpath("//div[text()='Change Status']")).click();
        Thread.sleep(2000);

        // Select 'New' status from the list
        driver.findElement(By.xpath("//span[text()='New']")).click();

        // Click on Apply button
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        Thread.sleep(3000);

        // Open change status dialog again
        driver.findElement(By.xpath("//div[text()='Change Status']")).click();

        // Change status to 'Planning'
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[7]")).click();
        driver.findElement(By.xpath("(//div[text()='Planning'])[2]")).click();
        Thread.sleep(3000);

        // Click on Apply button
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        Thread.sleep(3000);

        // Verify if status is changed to 'Planning'
        List<WebElement> listStatus = driver.findElements(By.xpath("//div[@class='taskStatusButton editable']/div"));
        boolean statusChanged = false;
        for (WebElement status : listStatus) {
            if (status.getText().equals("Planning")) {
                statusChanged = true;
                break;
            }
        }
        if (statusChanged) {
            System.out.println("Status is successfully changed to Planning");
        } else {
            throw new Exception("Status not changed to Planning");
        }
    }
    @AfterClass
    public void closeBrower(){
        driver.quit();
    }
}