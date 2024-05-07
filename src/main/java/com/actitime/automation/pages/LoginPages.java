package com.actitime.automation.pages;

import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

        WebDriver driver;
        CommonFunctions commonFunctions;
        public LoginPages(WebDriver driver){

            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
        public By username=By.id("username");

        public By password=By.xpath("//input[@type='password']");

       @FindBy(xpath = "//a[@id='loginButton']/child::div")
    WebElement loginButton;
       public void login(String username,String password){
        commonFunctions=new CommonFunctions(driver);
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        commonFunctions.click(loginButton);
       }
}
