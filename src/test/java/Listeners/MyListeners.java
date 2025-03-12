package Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class MyListeners implements ITestListener {

		public ExtentReports extent;
	    public ExtentTest test;
	   public WebDriver driver;
	    
	    @Override
	    public void onStart(ITestContext context) {
	        // Initialize ExtentReports
	        extent = new ExtentReports();
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Tester", "Supriya");
	    }
	    
	    
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName()+ "  is started");
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ "  is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+ "is failed");
		 driver = (WebDriver) result.getTestContext().getAttribute("driver");
		String testName = result.getMethod().getMethodName();
		try {
			screenshot(testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	  @Override
	    public void onFinish(ITestContext context) {
	        // Write all the results to the report
	        extent.flush();
	    }
	  
		public void screenshot(String testName) throws IOException
		{
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        
	            String screenshotPath = "C:\\Users\\lsupr\\eclipse-workspace\\registerchurch\\screenshots" + testName + System.currentTimeMillis() + ".png";
	          
	           FileUtils.copyFile(screenshot, new File(screenshotPath));	
	           }
	
}
