package com.myProject.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.myProject.Base.Base;

public class ListenerTest extends Base implements ITestListener {

	@Override
	public void onFinish(ITestContext Result) {
	}

	@Override
	public void onStart(ITestContext Result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}
	

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult Result) {
		System.out.println("The name of the test case failed is :" + Result.getName());
		//test.log(Status.FAIL, Result.getName());
		test.log(Status.FAIL, Result.getThrowable());
		
		//test.get().fail(Result.getThrowable());
		
	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the test case Skipped is :" + Result.getName());
		test.log(Status.SKIP, Result.getName());
		
	}

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName() + " test case started");
		test = extent.createTest(Result.getName());
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the test case passed is :" + Result.getName());
		test.log(Status.PASS, Result.getName());
	}

}
