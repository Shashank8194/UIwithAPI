package controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class WebDriverInitalize extends BrowserFactory {

    public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>(); //Why ??????????



@BeforeSuite(alwaysRun = false)
    public void suitesetup() {
        switch (Browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().arch64().setup();
                break;

            default:
                throw new NotFoundException("Browser not found");
        }
    }

@BeforeMethod
    public void beforeMethod() throws Exception {
        System.out.println("Browser is" + Browser);
        System.out.println("Website is" + WebSite);

       new WebDriverInitalize();

   WebDriver driver = WebDriverInitalize.createDriver();
    setWebDriver(driver);

    }

    public void setWebDriver(WebDriver driver) {
        wd.set(driver);
    }

    public static WebDriver getWebDriver() {
        return wd.get();
    }



}
