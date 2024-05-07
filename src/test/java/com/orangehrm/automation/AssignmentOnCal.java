package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.util.List;

public class AssignmentOnCal {
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
        driver.findElement(By.xpath("//body/div[@id='taskManagementPage']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[10]")).click();
        Thread.sleep(3000);
        WebElement entertask = driver.findElement(By.xpath("//span[text()='Flight operations']/following::input[1]"));
        entertask.sendKeys("Cyber Project");
        driver.findElement(By.xpath("//div[@class='components-Deadline-date--vW8sYsk2 components-Deadline-withoutDate--ZujIxVzy']")).click();
        Thread.sleep(3000);
        // driver.findElement(By.xpath("//tbody[@class='rc-calendar-tbody']/descendant::td[10]")).click();
        // Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Type of Work']/following::div[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='testing ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[45]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tr[@id='ext-gen16']/following::td[3]")).click();
        Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@class='components-SearchInput-searchInput--dlqxQrkh components-SearchInput-empty--TyuRV3fG']")).sendKeys("Cyber Project");

       String sendName = "Cyber Success Training";
        WebElement Startname = driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::input[1]"));
       Startname.sendKeys(sendName);
        Thread.sleep(3000);
        //WebElement CheckBox=driver.findElement(By.xpath("//tr[@class='taskRow noLastTrackingDate']/descendant::div[2]"));
        // CheckBox.click();
        WebElement textName = driver.findElement(By.xpath("//div[@title='Cyber Success Training']"));
        String Name = textName.getText();
        if (Name.equals(sendName)) {
            System.out.println("we are getting correct element");
        }
        driver.findElement(By.xpath("//div[@class='components-Deadline-date--vW8sYsk2 components-Deadline-withoutDate--ZujIxVzy deadlineDate']")).click();
        Thread.sleep(3000);
        int dayofmonth = LocalDateTime.now().getDayOfMonth();
        System.out.println("Day of month " + dayofmonth);
        String currmonth = LocalDateTime.now().getMonth().name();
        String actualCurrentmonth = currmonth.charAt(0) + currmonth.substring(1, currmonth.length()).toLowerCase();
        System.out.println(actualCurrentmonth);
        String monthXpath = "//td[starts-with(@title,'" + actualCurrentmonth + "')]/div";
        System.out.println(monthXpath);
        List<WebElement> days = driver.findElements(By.xpath(monthXpath));
        for (WebElement dayElement : days) {
            String day = dayElement.getText();
            System.out.println(day);
            if (day.equals(String.valueOf(dayofmonth))) {
                dayElement.click();
            }

        }
    }}