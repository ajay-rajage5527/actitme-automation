package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActitimeAssignment {

    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://online.actitime.com/oncospark1");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("rajagea3483@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(1000);
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
        driver.findElement(By.xpath("//tbody[@class='rc-calendar-tbody']/descendant::td[10]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Type of Work']/following::div[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='testing ']")).click();
        Thread.sleep(3000);
       driver.findElement(By.xpath("//body/div[45]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[1]")).click();
       Thread.sleep(5000);
      // driver.findElement(By.xpath("//tr[@id='ext-gen16']/following::td[3]")).click();
       //Thread.sleep(3000);
        WebElement Startname=driver.findElement(By.xpath("//input[@placeholder='Start typing a name...']"));
        Startname.sendKeys("Cyber Success Training");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tr[@class='taskRow noLastTrackingDate']/descendant::div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Assign to']")).click();
         Thread.sleep(3000);
         //click on 4 users field
        WebElement fourUser= driver.findElement(By.xpath("//tr[@id='ext-gen43']/following::td[3]"));
        //4users text stored below
        String ValueOfFourUser=fourUser.getText();
        System.out.println(ValueOfFourUser);
        fourUser.click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("(//span[@class='checkbox'])[3]")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//span[text()='Close']")).click();
         //changed 5 users text stored below
         String SecondUserValue=fourUser.getText();
        System.out.println(ValueOfFourUser);
         if(ValueOfFourUser.equals(SecondUserValue))
         {
             System.out.println("Test case is failed for user change");
         }
         else {
             throw new Exception("Test case is passed");
         }
        Thread.sleep(3000);
         WebElement assign=driver.findElement(By.xpath("//span[text()='Assign']"));
         assign.click();
}}
