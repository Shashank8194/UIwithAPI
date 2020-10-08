package controllers;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory extends InitMethod {

    static WebDriver driver;   //initialising the WebDriver instance


static  WebDriver createDriver() throws Exception
{

    switch (Browser.toLowerCase())
    {
        case "chrome":

            driver=new ChromeDriver();
            break;

        case "firefox":
            driver=new FirefoxDriver();
            break;

        default:
            throw new NotFoundException("Browser Not Found.Please Provide a valid browser");

    }
    driver.get(WebSite);
    driver.manage().window().maximize();
    return driver;
}

public static void implicitlywait(int timeInSeconds)
{
    driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
}



}
