package pageObjects.initializePageObjects;

import controllers.WebDriverInitalize;
import org.openqa.selenium.support.PageFactory;
import pageObjects.pages.HomePage;
import pageObjects.pages.WeatherPage;

public class pageFactoryInitialization extends WebDriverInitalize {

public HomePage homePage()
{
    return PageFactory.initElements(getWebDriver(),HomePage.class);

}

public WeatherPage weatherPage()
{
    return PageFactory.initElements(getWebDriver(), WeatherPage.class);
}
}
