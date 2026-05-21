package anandtomaracademy.resources;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import anandtomracademy.globalresources.Extentreportstest;


public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports ET = Extentreportstest.Extentreportstest();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	 @Override
	    public void onTestStart(ITestResult result) {
		 test = ET.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	extentTest.get().log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	extentTest.get().fail(result.getThrowable());
	    	try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} 
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	String filePath = null;
	    	try {
				filePath = takescreenshot(result.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    }

	    @Override
	    public void onStart(ITestContext context) {
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	ET.flush();
	    }




}
