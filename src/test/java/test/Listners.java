package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.artifacts;

import java.io.IOException;

public class Listners extends artifacts implements ITestListener {

    ExtentTest test;

    ExtentReports extentReports=artifacts.reporting();

    public void onTestFailure(ITestResult result)
    {
        test.fail(result.getThrowable());
        System.out.println("Cause of Fail is " +result.getName());

       String testCaseName= result.getMethod().getMethodName();
        try {
            screenshot(testCaseName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Cause of Fail is " +result.getName());

        test.log(Status.PASS,"Test is passed");

    }



    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        extentReports.flush();

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }



    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult result ) {
        // TODO Auto-generated method stub
       test= extentReports.createTest(result.getMethod().getMethodName());

    }


}

