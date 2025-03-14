package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

@Override
public boolean retry(ITestResult result) {
	int count = 0;
	int retrycount = 3;
	
	if(count<retrycount)
	{
		count++;
		return true;
	}
	
	return false;
}

}
