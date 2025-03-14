package Listeners;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.Base;


public class MyListeners extends Base implements ITestListener {

		//public ExtentReports extent;
	    public ExtentTest test;
	    public ChromeDriver driver ;
	    public ExtentSparkReporter spark;
	    ExtentReports extent = Base.extentreporting();
	    
	    @Override
	    public void onStart(ITestContext context)
	    {
	    	
	    	extent.createTest("Testing is started");
	       
	    }
	    
	    
	@Override
	public void onTestStart(ITestResult result) 
	{
		
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getName()+ "  is started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
		test.log(Status.PASS, result.getName()+ "  is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testname = result.getName();
		test.log(Status.FAIL, testname + " is failed");
		

		ChromeDriver driver = null;
		try {
			driver = (ChromeDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(captureScreenshot(driver,testname), testname);
		test.log(Status.INFO, result.getThrowable());
		
        //if (driver != null) {
		// String screenshotPath = captureScreenshot(driver, testname);
		 
	     //captureScreenshot(driver, testname);
	        
	     //test.fail("Failure Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
	

	  @Override
	    public void onFinish(ITestContext context) {
	        
	        extent.flush();
	    }
	  
	
	  
}
