package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementM {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.amazon.in");
        String title = driver.getTitle();
        System.out.println(title);
        String currenturl = driver.getCurrentUrl();
        System.out.println(currenturl);
        Thread.sleep(1000);
        WebElement searchtextbox=driver.findElement(By.id("twotabserachtextbox"));
        String attribute=searchtextbox.getAttribute("placeholder");
        System.out.println(attribute);
        WebElement getaddress= driver.findElement(By.id("twotabsearchtextbox"));
        String element=getaddress.getTagName();
        System.out.println(element);
        Thread.sleep(1000);


    }
}
