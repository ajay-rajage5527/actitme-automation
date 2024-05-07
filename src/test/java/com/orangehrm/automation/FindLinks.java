package com.orangehrm.automation;

import common.BaseClass;
import common.CommonFunctions;
import org.apache.commons.codec.binary.Base16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FindLinks extends BaseClass {
    CommonFunctions commonFunctions;
    WebDriver driver;
    @BeforeClass
    public void setup(){
          commonFunctions=new CommonFunctions(driver);
         driver=launchBrowser("chrome");
        driver.get("https:/www.amazon.in");
    }
    @Test
            public void test(){
        List<WebElement> webElementsList= driver.findElements(By.tagName("a"));
        for(WebElement element:webElementsList){
            String link=element.getAttribute("href");
            if(link!=null && !link.equals("javascript:void(0)")){
                System.out.println(link);
            }
        }
        driver.quit();

    }
    }

