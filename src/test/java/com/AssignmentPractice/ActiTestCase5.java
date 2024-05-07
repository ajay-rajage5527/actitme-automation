package com.AssignmentPractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ActiTestCase5 extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    TaskPages taskPages;
    LoginPages loginPages;

    @BeforeClass
    public void setUp() throws AWTException, InterruptedException {
        commonFunctions = new CommonFunctions(driver);
        loginPages=new LoginPages(driver);
        taskPages=new TaskPages(driver);
        driver =launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
    }

    @BeforeMethod
    public void beforemethod() throws AWTException, InterruptedException {
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
    }

    @Test(dataProvider="testData",priority = 1)
    public void usersModuleOpera(String FirstName,String LastName,String emailAd,String status) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Users']"))).click();

        //  WebElement newUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New User']")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newUser);

        WebElement newUser=driver.findElement(By.xpath("//div[text()='New User']"));
        commonFunctions.waitForElementClickable(newUser);
        newUser.click();

        WebElement firstName1= driver.findElement(By.xpath("(//div[@class='firstNameInputContainer'])[2]/child::input"));
        commonFunctions.waitForElementClickable(firstName1);
        firstName1.sendKeys(FirstName);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']"));
        lastName.sendKeys(LastName);

        WebElement email = driver.findElement(By.xpath("//input[@id='createUserPanel_emailField']"));
        email.sendKeys(emailAd);
        if(status.equals("test1")){
            System.out.println("user is created");
        }
        else if(status.equals("test2")){
            System.out.println("user2 is created");
        }
        WebElement department = driver.findElement(By.xpath("(//div[text()='-- department not assigned --'])[1]/parent::div"));
        department.click();
        driver.findElement(By.xpath("//div[text()='Quality Control']")).click();

        WebElement addRates = driver.findElement(By.xpath("(//span[text()='Add rates'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addRates);
        addRates.click();

        WebElement rateInput = driver.findElement(By.xpath("(//div[text()='Current'])[1]/following::input[1]"));
        rateInput.sendKeys("500");

        driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
        WebElement closeButton=driver.findElement(By.xpath("(//span[text()='Close'])[1]"));
        commonFunctions.waitForElementClickable(closeButton);
        Thread.sleep(5000);
    }
    @DataProvider
    public Object[][] testData(){
        Object[][] a=new Object[][]{
                {"sachin","Tendulakar2","st2@gmail.com","test1"},
                {"virat","Kohali"," virat@gmail.com","test2"}
        };
        return a;
    }
}
