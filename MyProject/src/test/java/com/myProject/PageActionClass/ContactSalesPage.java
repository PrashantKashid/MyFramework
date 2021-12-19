package com.myProject.PageActionClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactSalesPage {

	WebDriver driver;

	public ContactSalesPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id=\"header-navbar\"]/ul[3]/li[1]/a")
	WebElement btnConctactSales;

	public void navigateToContactSales() {
		btnConctactSales.click();
	}

}
