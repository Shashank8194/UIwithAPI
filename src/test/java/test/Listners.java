package test;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {

    public void onTestFailure(ITestResult result)
    {
        System.out.println("Cause of Fail is " +result.getName());

    }

    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Cause of Fail is " +result.getName());

    }
}
