package orangehrmPractice;

import com.actitime.automation.pages.LoginPages;
import com.orangehrm.automation.LoginPage;
import common.BaseClass;
import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Imageuploading extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPage loginPage;
    @BeforeClass
    public void setup() throws InterruptedException {
        driver=launchBrowser("chrome");
        loginPage=new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com");
        commonFunctions=new CommonFunctions(driver);
        loginPage.login("Admin","admin123");
    }
    @Test
    public void verifyImageUploading() throws InterruptedException {
         commonFunctions.click(By.xpath("//span[text()='My Info']"));
         commonFunctions.click(By.xpath("//img[@class=''employee-image]"));
         commonFunctions.click(By.xpath("//input[@type='file']/following-sibling::div/button"));
         Thread.sleep(1000);
    }
}
