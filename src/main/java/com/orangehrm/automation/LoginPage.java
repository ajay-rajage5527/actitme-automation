package com.orangehrm.automation;

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String username, String password) {
        CommonFunctions commonFunctions=new CommonFunctions(driver);
        commonFunctions.waitForElementToPresent(driver,driver.findElement(By.name("username")));
        driver.findElement(By.name("username")).sendKeys(username);
        commonFunctions.waitForElementToPresent(driver,driver.findElement(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void logout() {
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }

    public void verifyErrorMsg(String msg) throws Exception {
        if (msg.equals("Invalid credentials")) {
            System.out.println("Test Passed with invalid credentials");
        } else {
            throw new Exception("Test failed: error msg not displayed on login page");
        }
    }
    public void requireMsg(String message) throws Exception{
        if(message.equals("Required")){
            System.out.println("test case passed with error message as Required");
        }
        else{
            throw new Exception ("test case falailed");
        }
    }

}

