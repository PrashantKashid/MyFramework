package com.myProject.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.myProject.Base.Base;
import com.myProject.PageActionClass.GetFreeDemoPage;
import com.myProject.Utility.ListenerTest;

@Listeners(ListenerTest.class)
public class GetFreeDemoTest extends Base {

	Base base;
	GetFreeDemoPage demoPage;

	@Parameters({ "browser" })
	@BeforeMethod
	public void pageSetup(String browser) {
		base = new Base();
		base.initialize(browser);
		demoPage = PageFactory.initElements(driver, GetFreeDemoPage.class);
	}

	@AfterMethod
	public void end() {
		base.endTest();
	}

	@Test(priority = 1)
	public void navigateToGetDemoPage() {
		demoPage.navigateToDemoPage();
		test.log(Status.INFO, "navigated to GetFreeDemoPage.");
		String titleOfGetDemoPage = driver.getTitle();
		test.log(Status.INFO, "Title fetched for demo page");
		sa.assertEquals(titleOfGetDemoPage, "Sign Up for a Free HR Software Demo | OrangeHRM");
		sa.assertAll();
	}

	@Test(priority = 2, dataProvider = "Fetchdata")
	public void registerForFreeDemo(String firstName, String lastName, String email, int phoneNumber, String country,
			String state) throws InterruptedException {
		System.out.println("test" + firstName + "" + lastName + "" + email + "" + phoneNumber + "" + country);
		demoPage.navigateToDemoPage();
		demoPage.fillUsername(firstName);
		demoPage.fillLname(lastName);
		demoPage.fillemail(email);
		demoPage.fillContact(phoneNumber);
		test.log(Status.INFO, "Added phone number in form.");
		demoPage.fillcountry(country);
		demoPage.fillState(state);
		Thread.sleep(30000);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='recaptcha-anchor']/div[4]")));
		// demoPage.clickCaptcha();
		demoPage.clickButton();
		// Thread.sleep(20000);
		// String demoConfirmTitle = driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement thank = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div/div[1]/h1")));
		// System.out.println(demoConfirmTitle);
		sa.assertEquals(true, thank.isDisplayed());
		test.log(Status.INFO, "User landed on confirmed registration.");
		sa.assertAll();
	}

	@DataProvider(name = "Fetchdata")
	public static Object[][] passdata() throws IOException {
		Object[][] Total_data = null;
		Cell cell;
		File file = new File(".\\TestData\\GetFreeDemoData.xlsx");

		FileInputStream inputStream = new FileInputStream(file);

		Workbook Workbook = null;

		String filename = "Tests.xlsx";
		String fileExtensionName = filename.substring(filename.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			Workbook = new XSSFWorkbook(inputStream);

		}

		else if (fileExtensionName.equals(".xls")) {

			Workbook = new HSSFWorkbook(inputStream);

		}

		Sheet Sheet = Workbook.getSheet("UserDetails");

		// int last = Sheet.getLastRowNum();
		// int first = Sheet.getFirstRowNum();
		int rowCount = Sheet.getLastRowNum();
		Row row = Sheet.getRow(0);
		int cols = row.getLastCellNum();
		Total_data = new Object[rowCount][cols];
		System.out.println(rowCount);
		System.out.println(cols);

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cols; j++) {

				row = Sheet.getRow(i);
				cell = row.getCell(j);
				if (cell.getCellType() == CellType.STRING) {
					System.out.print(row.getCell(j).getStringCellValue() + "|| ");
					Total_data[i - 1][j] = row.getCell(j).getStringCellValue();
				}

				else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

					int Number = (int) Math.round(cell.getNumericCellValue());
					Total_data[i - 1][j] = Number;

				}
			}

			// System.out.println();
		}
		return Total_data;
	}

}
