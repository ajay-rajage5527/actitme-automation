package orangehrmPractice;

import com.actitime.automation.pages.LoginPages;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginwithOrangeHRM extends BaseClass {

    CommonFunctions commonFunctions;
    WebDriver driver;
    LoginPages loginPages;
    @BeforeClass
    public void setUp() throws InterruptedException {
        commonFunctions=new CommonFunctions(driver);
        driver=launchBrowser("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com");
    }
    @Test
    public void login() throws Exception {
        Thread.sleep(5000);
        WebElement usernameField=driver.findElement(By.xpath("//input[@name='username']"));
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // 10 seconds timeout
        wait.until(ExpectedConditions.visibilityOf(usernameField));*/
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        WebElement loginButton =driver.findElement(By.xpath("//input[@name='password']/following::div[1]"));
        loginButton.click();

        //verify logged is succefully or not
          Thread.sleep(3000);
        WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashText=dashboard.getText();

        if(dashText.equals("Dashboard")){
            System.out.println("Login successfully");
        }
        else {
           System.out.println("Unable to loggin");
        }
        WebElement pimModule=driver.findElement(By.xpath("//span[text()='PIM']"));

        pimModule.click();
           Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='oxd-autocomplete-wrapper'])[1]/descendant::input")).sendKeys("Ajay");
        driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).sendKeys("717");
        //driver.findElement(By.xpath("//label[text()='Supervisor Name']/following::input[1]")).sendKeys("Ritesh_Sir");
        WebElement addButton=driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/child::*"));
        addButton.click();

    }
}
