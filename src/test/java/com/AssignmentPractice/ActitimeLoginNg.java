package com.AssignmentPractice;

import com.actitime.automation.pages.TaskPages;
import com.orangehrm.automation.LoginPage;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActitimeLoginNg extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPage loginPage;
    TaskPages taskPages;

    @BeforeClass
    public void setup() throws InterruptedException {
       driver=launchBrowser("chrome");
       loginPage=new LoginPage(driver);
       driver.get("https://online.actitime.com/oncospark1");
       taskPages=new TaskPages(driver);
       commonFunctions=new CommonFunctions(driver);
       /* commonFunctions = new CommonFunctions();
        driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark");
        driver.manage().window().maximize();
        Thread.sleep(5000);*/
    }

    @Test(dataProvider = "getLoginTestData")
    public void verifyLogin(Object username, Object password, Object status) throws InterruptedException {
        commonFunctions.loginActitimeNg(username.toString(), password.toString());
        Thread.sleep(5000);
        String statusLogin = status.toString();


        if (statusLogin.equals("valid")) {
            String confirmLogin = driver.findElement(By.xpath("//div[text()='Tasks']")).getText();
            if (confirmLogin.equals("Tasks")) {
                System.out.println("Login successfully, Test case is passed");
            } else {
                System.out.println("Test case failed for login ");
            }
            Thread.sleep(3000);
            // For logout
            driver.findElement(By.xpath("(//a[text()='Logout'])[1]")).click();
            driver.navigate().refresh();
            Thread.sleep(3000);
            //done logout
        }


         else if (statusLogin.equals("valid1")) {
            String errorMessage=driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
            String str="Username or Password is invalid. Please try again.";
            //By using assert class
            Assert.assertEquals(errorMessage,str,"Test case passed for invalid(valid1) credentials");
          /*  if(errorMessage.equals(str)){
                 System.out.println("Test case passed for invalid(valid1) credentials");
            }
            else{
                System.out.println("Test case failed for invalid(valid1) credentials");
            }*/
            driver.navigate().refresh();
            Thread.sleep(3000);
        }


        else if (statusLogin.equals("valid2")) {
            String errorMessage=driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
            String str="Username or Password is invalid. Please try again.";
            if(errorMessage.equals(str)){
                System.out.println("Test case passed for invalid(valid2) credentials");
            }
            else{
                System.out.println("Test case failed for invalid(valid2) credentials");
            }
            driver.navigate().refresh();
            Thread.sleep(3000);
        }


        else if(statusLogin.equals("valid3")){
            String errorMessage=driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
            String str="Username or Password is invalid. Please try again.";
            if(errorMessage.equals(str)){
                System.out.println("Test case passed for blank username");
            }
            else{
                System.out.println("Test case failed for invalid(valid2) credentials");
            }
            driver.navigate().refresh();
            Thread.sleep(3000);
        }
        else if(statusLogin.equals("valid4")){
            String errorMessage=driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']")).getText();
            String str="Username or Password is invalid. Please try again.";
            if(errorMessage.equals(str)){
                System.out.println("Test case passed for both blanks username and password field ");
            }
            else{
                System.out.println("Test case failed for both blanks username and password field");
            }
            driver.navigate().refresh();
            Thread.sleep(3000);
        }
    }

    @DataProvider
    public Object[][] getLoginTestData() {
        Object[][] a = new Object[][]{
                {"rajagea3483@gmail.com", "Ajay5527", "valid"},
                {"rajagea3483@gmail.com", "ajay@#$", "valid1"},
                {"rajage@", "Ajay5527", "valid2"},
                {"", "Ajay5527", "valid3"},
                {"", "", "valid4"}
        };
        return a;

    }

}