package com.orangehrm.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTestNew {

    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(10000);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("Admin", "Admin123");
        Thread.sleep(1000);
        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashboardText = dashboard.getText();
        System.out.println(dashboardText);
        //verifying dashboard value
        if (dashboardText.equals("Dashboard")) {
            System.out.println("Successfully landed on dashboard");
        } else {
            throw new Exception("unable to login");
        }
        loginpage.logout();
        Thread.sleep(10000);
        //Invalid username and valid password
        loginpage.login("23650", "Admin123");
        Thread.sleep(10000);
        String errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
        loginpage.verifyErrorMsg(errorMsg);
        driver.navigate().refresh();
        Thread.sleep(10000);
        //valid username and invalid password
        loginpage.login("Admin", "Admin000");
        Thread.sleep(10000);
        errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
        loginpage.verifyErrorMsg(errorMsg);
        driver.navigate().refresh();
        Thread.sleep(10000);
        loginpage.login("","");
        String requireMsg=driver.findElement(By.xpath("//input[@name='_token']/following::span[]")).getText();
        loginpage.requireMsg(requireMsg);
        driver.navigate().refresh();
        Thread.sleep(5000);
    }}
