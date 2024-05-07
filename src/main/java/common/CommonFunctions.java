package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class CommonFunctions{

    WebDriver driver;

    public CommonFunctions(WebDriver driver) {
        this.driver=driver;
    }

    public  void loginForActitime(WebDriver driver)
    {

        driver.findElement(By.name("username")).sendKeys("rajagea3483@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ajay5527");
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
    }
    public void waitForElementToPresent(WebDriver driver, WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementClickable(WebElement element){
               WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
               wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void presenceOFElementLocated(By element){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
    public void loginActitimeNg(String username,String password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
    }
    public void fluentWait(By by){
        Wait<WebDriver> fluentWait=new FluentWait<>(driver)
            .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(Exception.class);
        Function<WebDriver,WebElement> function= (var) ->{
            System.out.println("Wait until element is available");
            return driver.findElement(by);
        };
        fluentWait.until(function);
    }
    public void click(WebElement element){
        waitForElementClickable(element);
        element.click();
    }
    public void click(By by){
        fluentWait(by);
        driver.findElement(by).click();
    }
}
