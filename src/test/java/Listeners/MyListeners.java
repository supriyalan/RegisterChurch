package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName()+ "  is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ "  is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+ "  is failed");
		
	}
	
}
