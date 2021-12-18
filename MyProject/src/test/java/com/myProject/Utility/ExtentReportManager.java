package com.myProject.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public static ExtentReports getReports()
	{
		if(extent==null) {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Report\\");
			spark.config().setReportName("My Test Report");
			spark.config().setDocumentTitle("Trial Test");
			spark.config().setTheme(Theme.DARK);
			spark.config().setEncoding("utf-8");
			extent.attachReporter(spark);
		}
		return extent;
	}
	
}
