package com.orangehrm.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class LoginTest {
    public static void main(String[] args) throws Exception {
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("118");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        //Navigate to url
        driver.get("https://opensource-demo.orangehrmlive.com");

        Thread.sleep(10000);
        //locate username element
        WebElement username=driver.findElement(By.name("username"));
        //enter admin username in the username element
        username.sendKeys("Admin");
        //locate password element
        WebElement password=driver.findElement(By.name("password"));
        //enter admin123 as password
        password.sendKeys("admin123");
        //locate login button
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        //click on login button
        loginButton.click();
        // wait dashboard module is loaded completely
        Thread.sleep(5000);

        WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashboardText=dashboard.getText();
        System.out.println(dashboardText);
        //verifying dashboard value
        if(dashboardText.equals("Dashboard")){
            System.out.println("Successfully landed on dashboard");
        }else{
            throw new Exception("unable to login");
        }
        Thread.sleep(10000);
        WebElement profile=driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i"));
        profile.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(8000);
        //FOR Valid username and invalid password
        try {

            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("Pass@123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(10000);
            if (!driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
                System.out.println("Login  to successful!");
            } else {
                throw new Exception("Login failed. Invalid Username and valid password unable to navigate to the next page.");
            }
        } catch (Exception e) {
            // If login fails or any exception occurs, catch the exception and print a corresponding error message
            System.out.println("Login failed: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging purposes
        }
    }
}
