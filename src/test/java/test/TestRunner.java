package test;
import apitest.fetchCityWeather;
import controllers.ExcelDataProvider;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.pageFactoryInitialization;

public class TestRunner extends pageFactoryInitialization {

   @Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class, enabled = true ,
        groups={"WEB"})
public void testNDTV(String CityName) throws InterruptedException {

   homePage().dismisspopup();
   homePage().clicksubmenu();
   homePage().clickweatheroption();
   weatherPage().searchbox(CityName);
   weatherPage().citycheckbox(CityName);
   weatherPage().weatherinfo();
}

@Test(groups = {"API"}, expectedExceptions = ArithmeticException.class )
public void apiNDTV()
{
   fetchCityWeather fetch= new fetchCityWeather();
   fetch.getRequest();
   fetch.getrequestResponse();
}
}
