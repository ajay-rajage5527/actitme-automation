package com.orangehrm.automation;

import com.actitime.automation.pages.LoginPages;
import com.actitime.automation.pages.TaskPages;
import common.BaseClass;
import common.CommonFunctions;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActitimeCustomerTCases extends BaseClass {
    CommonFunctions commonFunctions;
    TaskPages taskPages;
    WebDriver driver;
    LoginPages loginPages;
    @BeforeClass
    public void setup(){
        commonFunctions=new CommonFunctions(driver);
        driver=launchBrowser("chrome");
        driver.get("https://online.actitime.com/oncospark1");
        loginPages=new LoginPages(driver);
        taskPages=new TaskPages(driver);

    }
    @BeforeMethod
    public void login(){
        loginPages.login("rajagea3483@gmail.com","Ajay5527");
    }
@Test
public void test() throws InterruptedException {
    Actions actions=new Actions(driver);
    //click on tasks
    actions.click(driver.findElement(By.xpath("//div[text()='Tasks']"))).build().perform();
    Thread.sleep(3000);
    //click on add new button
    actions.click(driver.findElement(By.xpath("//div[text()='Add New']"))).build().perform();
    //click on add  customer
    actions.click(driver.findElement(By.xpath("//div[text()='+ New Customer']"))).build().perform();
    Thread.sleep(3000);
    //give customer name
    actions.sendKeys(driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")),"Jonnie1 cyber").build().perform();
//click on create customer
    actions.click(driver.findElement(By.xpath("//div[text()='Create Customer']"))).build().perform();
    String nameCust= driver.findElement(By.xpath("(//div[text()='Jonnie0 Walker'])[1]")).getText();
    if(nameCust.equals("AmazonCust")){
        System.out.println("Customer is succefully created");
    }
    else{
        System.out.println("Customer is not created");
    }
    Thread.sleep(3000);
    //create customer with invalid customer name
    actions.click(driver.findElement(By.xpath("//div[text()='Add New']"))).build().perform();
    actions.click(driver.findElement(By.xpath("//div[text()='+ New Customer']"))).build().perform();
    Thread.sleep(3000);
    actions.sendKeys(driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")),"JonnCyberie126").build().perform();
    Thread.sleep(3000);
    actions.click(driver.findElement(By.xpath("//div[text()='Create Customer']"))).build().perform();
    Thread.sleep(3000);
    //create customer with blank data
    actions.click(driver.findElement(By.xpath("//div[text()='Add New']"))).build().perform();
    actions.click(driver.findElement(By.xpath("//div[text()='+ New Customer']"))).build().perform();
    Thread.sleep(3000);
    actions.sendKeys(driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")),"").build().perform();
    Thread.sleep(3000);
    actions.click(driver.findElement(By.xpath("//div[text()='Create Customer']"))).build().perform();
    Thread.sleep(3000);
    String emptyCust= driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::div[1]")).getText();
    String str="Customer name cannot be empty";
    if(emptyCust.equals(str)){
        System.out.println("Test case is succefully passed");
    }
    else {
        System.out.println("Test case failed for empty customer name field");
    }

}
}




