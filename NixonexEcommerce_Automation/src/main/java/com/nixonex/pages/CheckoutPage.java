package com.nixonex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	@FindBy(id = "name")
	WebElement nameField;

	@FindBy(id = "country")
	WebElement countryField;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "card")
	WebElement cardField;

	@FindBy(id = "month")
	WebElement monthField;

	@FindBy(id = "year")
	WebElement yearField;

	@FindBy(xpath = "//button[text()='Purchase']")
	public WebElement purchaseButton;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	public void enterCountry(String country) {
		countryField.sendKeys(country);
	}

	public void enterCity(String city) {
		cityField.sendKeys(city);
	}

	public void enterCard(String cardNumber) {
		cardField.sendKeys(cardNumber);
	}

	public void enterMonth(String month) {
		monthField.sendKeys(month);
	}

	public void enterYear(String year) {
		yearField.sendKeys(year);
	}

}
