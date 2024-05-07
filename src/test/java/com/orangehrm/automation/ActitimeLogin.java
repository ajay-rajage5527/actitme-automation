package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActitimeLogin {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://online.actitime.com/cybersuccess7");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("cybersuccess@yopmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
         WebElement checkbox=driver.findElement(By.xpath("//div[@class='createdTasksTableContainer']/following::div[3]"));
         checkbox.click();
         Thread.sleep(5000);

         WebElement statusBtn=driver.findElement(By.xpath("//div[text()='Change Status']"));
         driver.manage().window().maximize();
        Thread.sleep(5000);
         statusBtn.click();
        Boolean status=statusBtn.isSelected();
        System.out.println(status);
         Thread.sleep(5000);
        WebElement newButton=driver.findElement(By.xpath("//div[text()='New Status:']/following::div[7]"));
        newButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='click to view project settings']/following::div[28]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        Thread.sleep(2000);
        String statuschange=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[3]/")).getText();
        System.out.println(statuschange);

}}
