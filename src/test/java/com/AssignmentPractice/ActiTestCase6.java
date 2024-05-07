package com.AssignmentPractice;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class ActiTestCase6 extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;
    TaskPages taskPages;

    @BeforeClass
    public void setUp() throws AWTException, InterruptedException {
        commonFunctions = new CommonFunctions(driver);
        driver =launchBrowser("chrome");
        loginPages=new LoginPages(driver);
        taskPages=new TaskPages(driver);
        driver.get("https://online.actitime.com/oncospark1");
    }

    @BeforeMethod
    public void loginActitime() throws AWTException, InterruptedException {
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
    }

    @Test(priority = 1)
    public void usersModuleOpera() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Users']"))).click();

        //  WebElement newUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New User']")));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", newUser);

        WebElement newUser = driver.findElement(By.xpath("//div[text()='New User']"));
        commonFunctions.waitForElementClickable(newUser);
        newUser.click();

        WebElement firstName1 = driver.findElement(By.xpath("(//div[@class='firstNameInputContainer'])[2]/child::input"));
        commonFunctions.waitForElementClickable(firstName1);
        firstName1.sendKeys("salman");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']"));
        lastName.sendKeys("khan");

        WebElement email = driver.findElement(By.xpath("//input[@id='createUserPanel_emailField']"));
        email.sendKeys("salman@gmail.com");

        WebElement department = driver.findElement(By.xpath("(//div[text()='-- department not assigned --'])[1]/parent::div"));
        department.click();
        driver.findElement(By.xpath("//div[text()='Quality Control']")).click();

        WebElement addRates = driver.findElement(By.xpath("(//span[text()='Add rates'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addRates);
        addRates.click();

        WebElement rateInput = driver.findElement(By.xpath("(//div[text()='Current'])[1]/following::input[1]"));
        rateInput.sendKeys("500");

        driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
        WebElement closeButton = driver.findElement(By.xpath("(//span[text()='Close'])[1]"));
        commonFunctions.presenceOFElementLocated(By.xpath("(//span[text()='Close'])[1]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",closeButton);
    }
}