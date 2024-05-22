package orangehrmPractice;

import com.actitime.automation.pages.LoginPages;
import com.orangehrm.automation.LoginPage;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginToOrangehrm extends BaseClass {
    CommonFunctions commonFunctions;
    WebDriver driver;
    LoginPages loginPages;
    @BeforeClass
    public void setUp(){
        commonFunctions=new CommonFunctions(driver);
        driver=launchBrowser("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com");
    }
    @Test(dataProvider = "testData")
    public void verifyLogin(Object username,Object password,Object status) throws Exception {
        System.out.println("Hello");
        WebElement username1=driver.findElement(By.xpath("//input[@name='username']"));
        commonFunctions.fluentWait(By.xpath("//input[@name='username']"));

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username.toString());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password.toString());

        WebElement orangeloginButton =driver.findElement(By.xpath("//input[@name='password']/following::div[1]"));
        orangeloginButton.click();
        if(status.toString().equals("login")){
            WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            if(dashboard.equals("Dashbaord")){
                System.out.println("Login successfully");
            }
            else {
                throw new Exception("unable to login");
            }
            //logout
            driver.findElement(By.xpath("//p[text()='Playwright Time']")).click();
            WebElement logOut=driver.findElement(By.xpath("//a[text()='Logout']"));
            logOut.click();
            driver.navigate().refresh();
        }
        else if(status.toString().equals("invalid")){
            WebElement error=driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
            String str="Invalid credentials";
            if(error.equals(str)){
                System.out.println("Test case passed for invalid credential");
            }
            else {
                throw new Exception("Test case failed for invalid data") ;
            }
        }

    }
    @DataProvider
    public Object[][]testData(){
        Object[][] data=new Object[][]{
                {"Admin","admin123","login"},
                {"usernamae","password","invalid"}
        };
        return data;
    }
}