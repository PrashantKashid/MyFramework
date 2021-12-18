package com.myProject.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myProject.Utility.ExtentReportManager;

public class Base {

	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static SoftAssert sa;

	/*
	 * ExtentReports extent; ExtentReports test;
	 */

	public void initialize(String browser) {
		//String browser = "chrome";
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\fireFoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.orangehrm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/*
	 * public void navigateTo() {
	 * 
	 * }
	 */


	public void endTest() {
		Base.driver.quit();

	}
	
	@BeforeSuite
	public void startSuite() {
		extent = ExtentReportManager.getReports();
		sa = new SoftAssert();
	}

	@AfterSuite
	public void endSuite() {
		extent.flush();
	}

	/*
	 * public static ExtentReports getInstance() { ExtentReports extent; //extent =
	 * new //ExtentSparkReporter spark = new
	 * ExtentSparkReporter("target/Spark.html"); //extent.attachReporter(spark);
	 * 
	 * //return extent; }
	 */

}
