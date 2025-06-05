package com.nixonex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "login2")
	public WebElement loginLink;

	@FindBy(id = "loginusername")
	private WebElement usernameField;

	@FindBy(id = "loginpassword")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;

	@FindBy(id = "nameofuser")
	private WebElement welcomeText;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // ✅ Essential for PageFactory
	}


	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public boolean isLoginSuccessful() {
		return welcomeText.isDisplayed();
	}
}
