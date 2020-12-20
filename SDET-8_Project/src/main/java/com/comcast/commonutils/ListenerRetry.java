package com.comcast.commonutils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenerRetry implements IRetryAnalyzer{
	 int counter = 1;
	 int retryLimit = 5;
	@Override
	public boolean retry(ITestResult result) {
		if(counter < retryLimit)
		 {
		 counter++;
		 return true;
		 }
		 return false;

	}

}
