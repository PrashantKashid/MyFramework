package com.myProject.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.myProject.Base.Base;
import com.myProject.PageActionClass.HomePage;
import com.myProject.Utility.ListenerTest;

@Listeners(ListenerTest.class)

public class HomePageCase extends Base {

	Base base;
	HomePage hp;

	@Parameters("browser")
	@BeforeMethod
	public void pageSetup(String browser) {
		base = new Base();
		base.initialize(browser);
		hp = PageFactory.initElements(driver, HomePage.class);
	}

	@AfterMethod
	public void end() {
		base.endTest();
	}

	@Test(priority = 1, groups = "Sanity")
	public void validatePageTitle() {
		String homeTitle = hp.getTitle();
		test.log(Status.INFO, "fetched title of page.");
		sa.assertEquals(homeTitle, "OrangeHRM HR Software | Free HR Software | HRMS | HRIS");
		sa.assertAll();
	}

	
	@Test(priority = 2, dependsOnMethods = { "validatePageTitle" }, groups = "Sanity")
	public void validateLogo() { // test =
		extent.createTest("Case2: HomePage_Validate page LOGO");
		boolean logo = hp.checkLogo();
		test.log(Status.INFO, "Fetching if logo present");
		sa.assertTrue(logo);
		sa.assertAll();
	}

	
	@Test(priority = 3, dataProvider = "FetchEmail")
	public void validateFNFreeTrailButton(String username, String email) {
		System.out.println(username + " " + email);
		hp.fnGetTrail(email);
		test.log(Status.INFO, "entered email and click on try free trail button");
		String titleFreeTrail = driver.getTitle();
		sa.assertEquals(titleFreeTrail, "Sign Up for a Free HR Software Trial | OrangeHRM");
		sa.assertAll();
	}
	
	
	
	@Test(priority = 4, dependsOnMethods = { "validateFNFreeTrailButton" }, dataProvider = "FetchEmail")
	public void validateFNFreeTrail(String username, String email) {
		System.out.println(username + " " + email);
		hp.fnGetTrail(email);
		test.log(Status.INFO, "entered email and click on try free trail button");
		String titleFreeTrail = driver.getTitle();
		sa.assertEquals(titleFreeTrail, "Sign Up for a Free HR Software Trial | OrangeHRM");
		sa.assertAll();
	}
	

	@Test(priority = 5)
	public void testAllLinksForHP() {
		HttpURLConnection huc = null;
		int respCode = 200;
		String url = "";
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href"); // System.out.println(url); if (url == null|| url.isEmpty()) {
													// //System.out.println("URL is either not configured for anchor tag
													// or it is empty");
			continue;
		}

		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			if (respCode >= 400) { // System.out.println(url + " is a broken link");
			} else { // System.out.println(url +" is a valid link");

			}
		} catch (MalformedURLException e) { // TODOAuto-generated catch block e.printStackTrace();

		} catch (IOException e) { // TODO Auto-generated catchblock
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void validateNavaigationPlatform() {
		hp.navigateToPlatformHR();
		String titleHrAdministration = driver.getTitle();
		// System.out.println(titleHrAdministration);
		sa.assertEquals(titleHrAdministration, "Tools for HR Managers and HR Departments | OrangeHRM");
		sa.assertAll();
	}

	@Test(priority = 7)
	public void validateNavigationWhyOrangeHRM() {
		hp.navigateToPlatformHR();
		String titleHrWhyOrangeHRM = driver.getTitle();
		System.out.println(titleHrWhyOrangeHRM);
		sa.assertEquals(titleHrWhyOrangeHRM, "Tools for HR Managers and HR Departments | OrangeHRM");
		sa.assertAll();
	}

	@Test(priority = 8)
	public void validateNavigationReSources() {
		hp.navigateToPlatformHR();
		String titleResources = driver.getTitle();
		System.out.println(titleResources);
		sa.assertEquals(titleResources, "Tools for HR Managers and HR Departments | OrangeHRM");
		sa.assertAll();
	}

	@Test(priority = 9)
	public void validateNavigationCompany() {
		boolean sectionAboutUS = hp.navigateToCompany();
		sa.assertTrue(sectionAboutUS);
		sa.assertAll();
	}

	@Test(priority = 10)
	public void navigateToHRAdministrationThroughButton() {
		boolean a = hp.buttonHRAdministartion();
		sa.assertTrue(a);
		sa.assertAll();
	}

	@Test(priority = 11)
	public void navigateEmployeeMgmtThroughButton() {
		boolean b = hp.buttonEmployeeMgmt();
		sa.assertTrue(b);
		sa.assertAll();
	}

	@Test(priority = 12)
	public void navigateReportingThroughButton() {
		boolean c = hp.buttonReportingCheck();
		sa.assertTrue(c);
		sa.assertAll();
	}

	@Test(priority = 13)
	public void validateNavigatePerformanceManagement() {
		boolean d = hp.clickOnCultureLearn();
		sa.assertTrue(d);
		sa.assertAll();
	}

	@Test(priority = 14)
	public void validateNavigateCarrerDevelopment() {
		boolean e = hp.clickOnCarrerDevelopment();
		sa.assertTrue(e);
		sa.assertAll();
	}

	@Test(priority = 15)
	public void validateClickOnTraining() {
		boolean f = hp.clickOnTraining();
		sa.assertTrue(f);
		sa.assertAll();
	}

	@Test(priority = 16)
	public void validateLearnTalentMgmt() {
		boolean g = hp.clickOnLearnMgmtBtn();
		sa.assertTrue(g);
		sa.assertAll();
	}

	@Test(priority = 17)
	public void validateNavigateToRecruitmentPage() {
		boolean h = hp.clickbtnRecruitment();
		sa.assertTrue(h);
		sa.assertAll();
	}

	@Test(priority = 18)
	public void validateNavigateToRecruitmentPageThroughButton() {
		boolean h = hp.clickbtnRecruitment();
		sa.assertTrue(h);
		sa.assertAll();
	}

	@Test(priority = 19)
	public void validateNavigateToOnBoardingPageThroughButton() {
		boolean i = hp.clickbtnOnBoarding();
		sa.assertTrue(i);
		sa.assertAll();
	}
	

	
	@DataProvider(name = "FetchEmail")
	public static Object[][] passEmail() throws IOException {
		Object[][] Total_data = null;
		Cell cell;
		File file = new File(".\\TestData\\EmailId.xlsx");

		FileInputStream inputStream = new FileInputStream(file);

		Workbook Workbook = null;

		String filename = "EmailId.xlsx";
		String fileExtensionName = filename.substring(filename.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			Workbook = new XSSFWorkbook(inputStream);

		}

		else if (fileExtensionName.equals(".xls")) {

			Workbook = new HSSFWorkbook(inputStream);

		}

		Sheet Sheet = Workbook.getSheet("Id");

		int last = Sheet.getLastRowNum();
		int first = Sheet.getFirstRowNum();
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
		}
		return Total_data;
	}
	
}