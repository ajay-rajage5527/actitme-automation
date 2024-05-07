package com.orangehrm.automation;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.util.List;

public class DatePickerExample {

    public static void main(String[] args) throws InterruptedException{
       int dayofmonth=LocalDateTime.now().getDayOfMonth();
       System.out.println("Day of month "+dayofmonth);
        String currmonth=LocalDateTime.now().getMonth().name();
        String actualCurrentmonth=currmonth.charAt(0)+currmonth.substring(1,currmonth.length()).toLowerCase();
        System.out.println(actualCurrentmonth);
        //browser setup
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://online.actitime.com/cybersuccess7");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("cybersuccess@yopmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body/div[@id='taskManagementPage']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[10]")).click();
        Thread.sleep(3000);
        WebElement entertask=driver.findElement(By.xpath("//span[text()='Flight operations']/following::input[1]"));
        entertask.sendKeys("Cyber Success Training");
        driver.findElement(By.xpath("//div[@class='components-Deadline-date--vW8sYsk2 components-Deadline-withoutDate--ZujIxVzy']")).click();
        Thread.sleep(3000);
        String monthXpath="//td[starts-with(@title,'"+actualCurrentmonth+"')]/div";
        System.out.println(monthXpath);
       List<WebElement> days=driver.findElements(By.xpath(monthXpath));
       for(WebElement dayElement : days){
        String day=dayElement.getText();
        System.out.println(day);
        if(day.equals(String.valueOf(dayofmonth))){
         dayElement.click();
        }
       }
    }
}
