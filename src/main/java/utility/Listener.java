package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static utility.Screenshot.takeScreenshot;
import static utility.ExtentReport.getTest;
import static utility.ExtentReport.extentReports;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.SneakyThrows;


public class Listener extends BaseClass implements ITestListener{


	    private final static Logger Log = LogManager.getLogger(BaseClass.class);

	    private String logMessage(final String methodName, final String status) {
	        return String.format("%s %s", methodName, status.toUpperCase());
	    }

	    public void onStart(ITestContext context) {
	        Log.info(logMessage(context.getName(), "TEST START"));
	    }

	    public void onTestStart(ITestResult result) {
	        Log.info(logMessage(result.getMethod().getMethodName(), "START"));
	        result.setAttribute("AndroidDriver", getDriver());
	    }

	  

		public void onTestSuccess(ITestResult result) {
	        getTest().pass("Test PASSED");
	        Log.info(logMessage(result.getMethod().getMethodName(), "PASS"));
	    }

	   

		@SneakyThrows
	    public void onTestFailure(ITestResult result) {
	   
	        Log.error(logMessage(result.getMethod().getMethodName(), "FAIL"));
	        Object testClass = result.getInstance();
	        AndroidDriver<AndroidElement> driver = ((BaseClass) testClass).getDriver();
	        getTest().addScreenCaptureFromPath(takeScreenshot(result.getMethod().getMethodName(), driver));
	        getTest().fail(result.getThrowable());
	    //    getTest().fail("Test FAILED");
	       
	    }

	    public void onTestSkipped(ITestResult result) {
	        Log.warn(logMessage(result.getMethod().getMethodName(), "SKIP"));
	        getTest().skip("Test SKIPPED");
	    }

	    public void onFinish(ITestContext context) {
	        Log.info(logMessage(context.getName(), "TEST FINISH"));
	        extentReports.flush();
	    }
	}


