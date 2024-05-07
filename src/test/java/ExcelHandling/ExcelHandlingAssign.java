package ExcelHandling;

import com.actitime.automation.pages.LoginPages;
import common.BaseClass;
import common.CommonFunctions;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ExcelHandlingAssign extends BaseClass {
    WebDriver driver;
    CommonFunctions commonFunctions;
    LoginPages loginPages;

Sheet sheet;
    @BeforeClass public void browserSetup() throws InterruptedException, AWTException {
        commonFunctions = new CommonFunctions(driver);
        driver =launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
        driver.manage().window().maximize();
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_MINUS);
        rbt.keyRelease(KeyEvent.VK_MINUS);
        rbt.keyPress(KeyEvent.VK_MINUS);
        rbt.keyRelease(KeyEvent.VK_MINUS);
        rbt.keyPress(KeyEvent.VK_MINUS);
        rbt.keyRelease(KeyEvent.VK_MINUS);
        Thread.sleep(5000);
    }


    @Test
    public void writeAllCust() {
        // commonFunctions.waitForElementClickable(driver.findElement(By.xpath("//div[text()='Tasks']")));
        WebElement tasks = driver.findElement(By.xpath("//div[text()='Tasks']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", tasks);

        List<WebElement> customerList = driver.findElements(By.xpath("//div[@class='node customerNode notSelected editable']"));
      /*  for (WebElement list : customerList) {
            String custTNames = list.getText();
            System.out.println(custTNames);
        }*/
        List<WebElement> projectList= driver.findElements(By.xpath("//div[@class='text']"));
        /*for (WebElement listProject : projectList) {
            String projectNames = listProject.getText();
            System.out.println(projectNames);
        }*/



         for(int i=0;i<customerList.size();i++){
             Row row=sheet.createRow(i);
            Cell cell=row.createCell(0);
            WebElement element=customerList.get(i);
            String customerNames=element.getText();
            cell.setCellValue(customerNames);

            WebElement element1=projectList.get(i);
            String projectNames=element1.getText();
            cell.setCellValue(projectNames);
         }
    }
}
