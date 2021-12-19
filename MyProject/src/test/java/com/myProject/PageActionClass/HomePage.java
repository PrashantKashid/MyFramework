package com.myProject.PageActionClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//img[@alt='OrangeHRM Inc Logo']")
	WebElement logo;

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement emailIdField;

	@FindBy(xpath = "//input[@value='Try OrangeHRM for Free']")
	WebElement tryButton;

	@FindBy(xpath = "//a[@href='/hris-hr-software-demo/']")
	WebElement getFreeDemoButton;

	@FindBy(xpath = "//*[@id='myText']")
	WebElement txtEmailForFree;

	@FindBy(xpath = "//a[@href='/orangehrm-30-day-trial/']")
	WebElement btnTryOHRMFree;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[1]/a/span")
	WebElement lnkCatPlatform;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[1]/div/div[1]/div[1]/div/div[1]/p[1]/a")
	WebElement lnkSubCatPlatform;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[2]/a/span")
	WebElement lnkCatWhyOrangeHRM;

	@FindBy(xpath = "//*[@id='header-navbar]/ul[1]/li[2]/div/div/div[1]/div/div[1]/p[1]/a")
	WebElement lnkSubCatWhyOrangeHRM;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[3]/a/span")
	WebElement lnkCatResources;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[3]/div/div/div[1]/div/div[1]/p[1]/a")
	WebElement lnkSubCatResources;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[4]/a/span")
	WebElement lnkCatCompany;

	@FindBy(xpath = "//*[@id='header-navbar']/ul[1]/li[4]/ul/div/div/div/p[1]/a")
	WebElement lnkSubCatAboutUS;

	@FindBy(xpath = "//h1[text()='About OrangeHRM']")
	WebElement sectionAboutUS;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[1]/div[2]/ul/li[1]/a/div[2]/div/p")
	WebElement lnkHRAdministration;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionHRAdministration;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[1]/div[2]/ul/li[2]/a/div[2]/div/p")
	WebElement buttonEmpMgmt;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionEmpMgmt;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[1]/div[2]/ul/li[3]/a/div[2]/div/p")
	WebElement buttonReporting;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionReporting;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[2]/div[1]/div[1]/div/div/a/button")
	WebElement btnCultureLearnMore;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionPerformanceManagement;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[2]/div[2]/ul/li[1]/a/div[2]/div/p")
	WebElement btnPerformance;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[2]/div[2]/ul/li[2]/a/div[2]/div/p")
	WebElement btnCareerDevelopment;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionCareerDevelopment;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[2]/div[2]/ul/li[3]/a/div[2]/div/p")
	WebElement btnTraining;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionTraining;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[3]/div[1]/div[2]/div/div/a/button")
	WebElement btnLearnMoreTalentMgmt;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionRecruitment;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[3]/div[2]/ul/li[1]/a/div[2]/div/p")
	WebElement btnRecruitment;

	@FindBy(xpath = "/html/body/div[5]/div[3]/div[3]/div[2]/ul/li[2]/a/div[2]/div/p")
	WebElement btnOnboarding;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/h3")
	WebElement sectionOnboarding;

	// ---------------------Methods-----------------------------------------

	public boolean checkLogo() {
		return logo.isDisplayed();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void navigateTogetFreeDemo() {
		getFreeDemoButton.click();
	}

	public void fnGetTrail(String email) {
		txtEmailForFree.sendKeys(email);
		btnTryOHRMFree.click();
	}

	public void navigateToPlatformHR() {
		lnkCatPlatform.click();
		lnkSubCatPlatform.click();
	}

	public void navigateToWhyOrangeHRM() {
		lnkCatWhyOrangeHRM.click();
		lnkSubCatWhyOrangeHRM.click();
	}

	public void navigateToResources() {
		lnkCatResources.click();
		lnkSubCatResources.click();
	}

	public boolean navigateToCompany() {
		lnkCatCompany.click();
		lnkSubCatAboutUS.click();
		return sectionAboutUS.isDisplayed();
	}

	public boolean buttonHRAdministartion() {
		lnkHRAdministration.click();
		return sectionHRAdministration.isDisplayed();
	}

	public boolean buttonEmployeeMgmt() {
		buttonEmpMgmt.click();
		return sectionEmpMgmt.isDisplayed();
	}

	public boolean buttonReportingCheck() {
		buttonReporting.click();
		return sectionReporting.isDisplayed();
	}

	public boolean clickOnCultureLearn() {
		btnCultureLearnMore.click();
		return sectionPerformanceManagement.isDisplayed();
	}

	public boolean clickOnPerformanceButton() {
		btnPerformance.click();
		return sectionPerformanceManagement.isDisplayed();
	}

	public boolean clickOnCarrerDevelopment() {
		btnCareerDevelopment.click();
		return sectionCareerDevelopment.isDisplayed();
	}

	public boolean clickOnTraining() {
		btnTraining.click();
		return sectionTraining.isDisplayed();
	}

	public boolean clickOnLearnMgmtBtn() {
		btnLearnMoreTalentMgmt.click();
		return sectionRecruitment.isDisplayed();
	}

	public boolean clickbtnRecruitment() {
		btnRecruitment.click();
		return sectionRecruitment.isDisplayed();
	}

	public boolean clickbtnOnBoarding() {
		btnOnboarding.click();
		return sectionOnboarding.isDisplayed();
	}

}
