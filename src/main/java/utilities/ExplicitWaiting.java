package utilities;

import controllers.WebDriverInitalize;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaiting extends WebDriverInitalize {

public static void explicitWaitElementToBeClickable(WebElement element,int time)
{
    WebDriverWait clickableWait= new WebDriverWait(getWebDriver(),time);
    clickableWait.until(ExpectedConditions.elementToBeClickable(element));
}

    public static void explicitWaitVisibilityOfElement(WebElement element, int time) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getWebDriver(), time);
        elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
    }
}
