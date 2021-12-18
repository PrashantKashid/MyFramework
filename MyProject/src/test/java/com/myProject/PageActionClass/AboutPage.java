package com.myProject.PageActionClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.myProject.Base.Base;
import com.myProject.Utility.ListenerTest;

public class AboutPage extends Base {

	WebDriver driver;

	public AboutPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[4]/a/span")
	WebElement btnCompany;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[4]/ul/div/div/div/p[1]/a")
	WebElement lnkAboutUs;

	@FindBy(xpath = "/html/body/section[1]/div/div/div/div/div/a")
	WebElement btnGetFreeDemo;

	@FindBy(xpath = "//*[@id=\"demoRequest\"]/div/div/div/div/div[1]/div/h3")
	WebElement bannerForAdv;

	@FindBy(xpath = "/html/body/section[2]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div/a")
	WebElement linkPeopleMgmt;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionHRMgmt;

	@FindBy(xpath = "/html/body/section[2]/div[2]/div[2]/div/div/div/div/div[3]/div[2]/div/a")
	WebElement btnCompensastion;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionPayrollConnector;

	@FindBy(xpath = "/html/body/section[2]/div[2]/div[2]/div/div/div/div/div[4]/div[2]/div/a")
	WebElement btnTalentMgmt;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionRectuitment;

	@FindBy(xpath = "/html/body/section[2]/div[2]/div[2]/div/div/div/div/div[5]/div[2]/div/a")
	WebElement btnCulture;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionPerformanceMgmt;

	@FindBy(xpath = "/html/body/section[4]/div/div/div/a")
	WebElement btngetFreeDemo;

	@FindBy(xpath = "//*[@id=\"demoRequest\"]/div/div/div/div/div[1]/div/h3")
	WebElement sectionAdv;

	// -----------

	public void navigateToAboutUS() {
		btnCompany.click();
		lnkAboutUs.click();
	}

	public boolean clickBtnGetFreeDemo() {
		btnGetFreeDemo.click();
		return bannerForAdv.isDisplayed();
	}

	public boolean clickBtnPeopleMgmt() {
		linkPeopleMgmt.click();
		return sectionHRMgmt.isDisplayed();
	}

	public boolean clickBtnCompensastion() {
		btnCompensastion.click();
		return sectionPayrollConnector.isDisplayed();
	}

	public boolean clickbtnTalentMgmt() {
		btnTalentMgmt.click();
		return sectionRectuitment.isDisplayed();
	}

	public boolean clickbtnCulture() {
		btnTalentMgmt.click();
		return sectionPerformanceMgmt.isDisplayed();
	}

	public boolean clickbtngetFreeDemo() {
		btngetFreeDemo.click();
		return sectionAdv.isDisplayed();
	}

}
