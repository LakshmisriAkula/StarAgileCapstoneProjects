package com.orangehrm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
	WebDriver driver;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(css = "button[type='submit']")
	WebElement loginButton;

	public static @FindBy(xpath = "//p[@class='oxd-userdropdown-name']") WebElement profile;

	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}

	public void logout() {
		profile.click();
		logoutLink.click();
	}

}
