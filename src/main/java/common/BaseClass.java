package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseClass {
    WebDriver driver;
    public WebDriver launchBrowser(String browserName){
        switch(browserName){
            case "chrome":
                ChromeOptions options=new ChromeOptions();
                options.setBrowserVersion("118");
                options.addArguments("--remote-allow-origins=*");
                driver=new ChromeDriver(options);
                break;
            case  "edge":
                EdgeOptions options1=new EdgeOptions();
                options1.setBrowserVersion("stable");
                driver=new EdgeDriver(options1);
                break;
            case "firefox":
                FirefoxOptions options2=new FirefoxOptions();
                options2.setBrowserVersion("stable");
                driver=new FirefoxDriver(options2);
                break;
            default :
                ChromeOptions options3=new ChromeOptions();
                options3.setBrowserVersion("stable");
                options3.addArguments("--remote-allow-origins=*");
                driver=new ChromeDriver(options3);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
