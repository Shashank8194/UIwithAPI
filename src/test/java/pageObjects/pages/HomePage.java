package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.pageFactoryInitialization;
import utilities.ExplicitWaiting;

public class HomePage extends pageFactoryInitialization {

    ExplicitWaiting explicitWaiting=new ExplicitWaiting();

@FindBy(xpath="//a[@id='h_sub_menu']")
private WebElement submenu;

@FindBy(linkText = "WEATHER")
    private WebElement weatheroption;

@FindBy(xpath = "//*[@class='noti_btnwrap']/a[1]" )
    private WebElement popupDismiss;


public HomePage clicksubmenu()
{
submenu.click();
return this;
}

public HomePage dismisspopup() throws InterruptedException {
    ExplicitWaiting.explicitWaitVisibilityOfElement(popupDismiss,60);

    if (popupDismiss.isDisplayed())
    {

        popupDismiss.click();

    }
    else
    {
        ExplicitWaiting.explicitWaitVisibilityOfElement(popupDismiss,30);
    }
    return this;
}

public HomePage clickweatheroption() throws InterruptedException {
    ExplicitWaiting.explicitWaitElementToBeClickable(weatheroption,20);
   // Thread.sleep(2000);
    weatheroption.click();
    return this;
}
}
