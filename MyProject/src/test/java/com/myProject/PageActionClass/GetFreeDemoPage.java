package com.myProject.PageActionClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myProject.Base.Base;

public class GetFreeDemoPage {
	WebDriver driver;
	
	public GetFreeDemoPage(WebDriver driver) {
		this.driver = driver;
		
	}

	@FindBy(xpath = "//*[@id=\"header-navbar\"]/ul[3]/li[2]/a")
	WebElement goToDemoPage;
	
	@FindBy(xpath = "//input[@name='FirstName']")
	public
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='LastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='Email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='Contact']")
	WebElement contact;
	
	@FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div/div/form/fieldset/div[5]/div/select")
	WebElement country;
	
	@FindBy(xpath = "/html/body/section[1]/div/div/div/div/div[2]/div/div/form/fieldset/div[6]/div/select")
	WebElement states;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")
	WebElement captcha;
	
	@FindBy(xpath = "//*[@id='Form_submitForm_action_request']")
	WebElement demoButton;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div/div[1]/h1")
	WebElement thankYou;
	
	@FindBy(xpath = "/html/body/section[5]/div/div/div/div/a")
	WebElement bigGetFreeDemoButton;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div[1]/h3")
	WebElement activeUserSection;
	
	@FindBy(xpath = "//a[@href='/hris-hr-software-demo/']")
	WebElement navigationGetFreeDemoButton;
	

	//---------------------Methods-----------------------------------------
	
	public void navigateToDemoPage()
	{
		goToDemoPage.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public void fillUsername(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void fillLname(String lname) {
		lastName.sendKeys(lname);
		
	}
	
	public void fillemail(String emailId)
	{
		email.sendKeys(emailId);
	}
	
	public void fillContact(int contactNo)
	{
		contact.sendKeys(String.valueOf(contactNo));
	}
	
	public void fillcountry(String countryName)
	{
		country.sendKeys(countryName);
	}
	
	public void fillState(String state)
	{
		states.sendKeys(state);
	}
	
	
	public void clickCaptcha()
	{
	captcha.click();
	}
	
	public void clickButton()
	{
		demoButton.click();
	}
	
	public void clickBigGetDemoButton() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		bigGetFreeDemoButton.click();
		
	}
	
	public void navigateTogetFreeDemo()
	{
		navigationGetFreeDemoButton.click();
	}

}
