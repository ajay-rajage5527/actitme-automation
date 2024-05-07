package com.orangehrm.automation;

import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginOrangeHrmTestng  extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    @BeforeClass
    public void setup() throws InterruptedException {
         commonFunctions=new CommonFunctions(driver);
         driver =launchBrowser("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com");
        }
        @Test(dataProvider = "getLoginTestData")
    public void verifyLogin(Object username,Object password,Object status) throws Exception {
            LoginPage loginpage = new LoginPage(driver);
            Thread.sleep(3000);
            loginpage.login(username.toString(),password.toString());
            Thread.sleep(10000);
            String statusInput=status.toString();
            if(statusInput.equals("valid")){
                commonFunctions.waitForElementClickable(driver.findElement(By.xpath("//h6[text()='Dashboard']")));
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
            }
            else if(statusInput.equals("invalid1")){
                String errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
                loginpage.verifyErrorMsg(errorMsg);
                driver.navigate().refresh();
                Thread.sleep(10000);
            }
            else if(statusInput.equals("invalid2")){
                Thread.sleep(5000);
                String requireMsg1=driver.findElement(By.xpath("(//span[text()='Required'])[1]")).getText();
                String requireMsg2=driver.findElement(By.xpath("(//span[text()='Required'])[2]")).getText();
                if(requireMsg1.equals("Required")&&(requireMsg2.equals("Required"))) {
                    System.out.println("Test Case passed for Required error message");
                }
                else {
                    System.out.println("Test Case failed for Required message");
                }
                driver.navigate().refresh();
                Thread.sleep(5000);
            }
            else if(statusInput.equals("invalid3")){
                Thread.sleep(5000);
                String requireMsg3=driver.findElement(By.xpath("(//span[text()='Required'])[1]")).getText();
                if(requireMsg3.equals("Required")){
                    System.out.println("Test case passed for blank password field");
                }
                else{
                    System.out.println("Test case failed for blank password field");
                }
                driver.navigate().refresh();
            }
        }
        @DataProvider
    public Object[][] getLoginTestData(){
        Object [][]obj=new Object[][]{
                {"Admin","admin123","valid"},
                {"Admin","admin","invalid1"},
                {" ","","invalid2"},
                {"Admin","","invalid3"}
        };
        return obj;
        }
}
