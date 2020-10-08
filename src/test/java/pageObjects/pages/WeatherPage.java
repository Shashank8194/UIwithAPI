package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.pageFactoryInitialization;
import utilities.ExplicitWaiting;

public class WeatherPage extends pageFactoryInitialization {

    @FindBy(id = "searchBox")
    private WebElement searchcity;

    @FindBy(xpath = "//input[@id='Jaipur']")
    private WebElement citycheckbox;

    @FindBy(xpath = "//div[10]//div[1]//div[2]")
    private WebElement cityinformation;

    @FindBy(xpath = "//div[@class='outerContainer' and @title='Jaipur']")
    private WebElement weatherinformation;

    @FindBy(xpath = "//div[contains(text(),'Jaipur')]")
    private WebElement cityonweatherpage;

    @FindBy(xpath = "//div[@class='outerContainer' and @title='New Delhi']//div//span[1]")
    private WebElement tempindegrees;

    @FindBy(xpath = "//div[@class='outerContainer' and @title='New Delhi']//div//span[2]")
    private WebElement tempinfarenheit;


    public WeatherPage searchbox(String CityName)
    {
        ExplicitWaiting.explicitWaitVisibilityOfElement(searchcity,10);
        searchcity.sendKeys(CityName);
        return this;
    }

    public WeatherPage citycheckbox(String CityName)
    {
        ExplicitWaiting.explicitWaitElementToBeClickable(citycheckbox,10);
        citycheckbox.click();
       /* String city=searchcity.getText();
        System.out.println(city);*/
        String cityonweatherdetail=cityonweatherpage.getText();
        System.out.println(cityonweatherdetail);
        Assert.assertEquals(CityName,cityonweatherdetail);
        return this;
    }

    public WeatherPage weatherinfo()
    {
        ExplicitWaiting.explicitWaitVisibilityOfElement(weatherinformation,10);
        String weatherindegrees=tempindegrees.getText();
        System.out.println("Temperature in Degree" + weatherindegrees);
        String weatherinfarenheit = tempinfarenheit.getText();
        System.out.println("Temperature in Farenheit" + weatherinfarenheit);
        return  this;
    }


}
