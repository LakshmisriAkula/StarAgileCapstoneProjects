package com.nixonex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;

	@FindBy(css = ".sweet-alert h2")
	WebElement confirmationText;

	@FindBy(css = ".sweet-alert p")
	WebElement orderDetails;

	@FindBy(xpath = "//button[text()='OK']")
	public WebElement okButton;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean isConfirmationDisplayed() {
		return confirmationText.isDisplayed();
	}

	public String getOrderDetails() {
		return orderDetails.getText();
	}

}
