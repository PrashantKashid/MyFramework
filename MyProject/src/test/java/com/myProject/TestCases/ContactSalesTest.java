package com.myProject.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.myProject.Base.Base;
import com.myProject.PageActionClass.ContactSalesPage;
import com.myProject.Utility.ListenerTest;

@Listeners(ListenerTest.class)

public class ContactSalesTest extends Base {

	Base base;
	ContactSalesPage cSP;

	@Parameters("browser")
	@BeforeMethod
	public void pageSetup(String browser) {
		base = new Base();
		base.initialize(browser);
		cSP = PageFactory.initElements(driver, ContactSalesPage.class);
	}

	@AfterMethod
	public void end() {
		base.endTest();
	}

	@Test(priority = 1)
	public void navigateToContactSalesPage() {
		cSP.navigateToContactSales();
		test.log(Status.INFO, "Clicked button for sales Page");
		String cSPTitle = driver.getTitle();
		sa.assertEquals("c", "s");
		test.log(Status.INFO, "title of page is " + cSPTitle);
	}

}
