package com.myProject.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myProject.Base.Base;
import com.myProject.PageActionClass.AboutPage;
import com.myProject.Utility.ListenerTest;

@Listeners(ListenerTest.class)

public class AboutPageCase extends Base {

	Base base;
	AboutPage aboutPage;

	@Parameters("browser")
	@BeforeMethod
	public void pageSetup(String browser) {
		base = new Base();
		base.initialize(browser);
		aboutPage = PageFactory.initElements(driver, AboutPage.class);
	}

	@AfterMethod
	public void end() {
		base.endTest();
	}

	@Test(priority = 1)
	public void validateclickBtnGetFreeDemo() {
		aboutPage.navigateToAboutUS();
		boolean aa = aboutPage.clickBtnGetFreeDemo();
		System.out.println(aa);
		sa.assertTrue(aa);
		sa.assertAll();
	}

	@Test(priority = 2)
	public void validateclickBtnPeopleMgmt() {
		aboutPage.navigateToAboutUS();
		boolean ab = aboutPage.clickBtnPeopleMgmt();
		System.out.println(ab);
		sa.assertTrue(ab);
		sa.assertAll();
	}

	@Test(priority = 3)
	public void validateclickbtngetFreeDemo() {
		aboutPage.navigateToAboutUS();
		boolean acc = aboutPage.clickbtngetFreeDemo();
		System.out.println(acc);
		sa.assertTrue(acc);
		sa.assertAll();
	}

	@Test(priority = 4)
	public void validateclickBtnCompensastion() {
		aboutPage.navigateToAboutUS();
		boolean ac = aboutPage.clickBtnPeopleMgmt();
		System.out.println(ac);
		sa.assertTrue(ac);
		sa.assertAll();
	}

	@Test(priority = 5)
	public void validateclickbtnTalentMgmt() {
		aboutPage.navigateToAboutUS();
		boolean ad = aboutPage.clickbtnTalentMgmt();
		System.out.println(ad);
		sa.assertTrue(ad);
		sa.assertAll();
	}

	@Test(priority = 6)
	public void validateclickbtnCulture() {
		aboutPage.navigateToAboutUS();
		boolean ae = aboutPage.clickbtnCulture();
		System.out.println(ae);
		sa.assertTrue(ae);
		sa.assertAll();
	}

}
