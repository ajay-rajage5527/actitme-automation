package com.orangehrm.automation;

import com.sun.source.util.SourcePositions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.net.SocketOption;
import java.util.List;

public class MultiSelectDropDown {
    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://letcode.in");
        WebElement dropdown =driver.findElement(By.id("superheros"));
        Select select=new Select(dropdown);
        List<WebElement> alloptions=select.getOptions();
        for(int i=0;i<alloptions.size();i++)
        {
            WebElement option=alloptions.get(i);
            String text=option.getText();
            System.out.println(text);
        }

    }
}
