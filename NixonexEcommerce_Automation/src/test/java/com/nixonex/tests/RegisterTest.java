package com.nixonex.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nixonex.base.TestBase;
import com.nixonex.pages.RegisterPage;

public class RegisterTest extends TestBase {
	RegisterPage registerPage;
	String username = "user" + System.currentTimeMillis();

	@BeforeMethod
	public void setUp() {
		initialization();
		registerPage = new RegisterPage(driver);
	}

	@Test
	public void testUserRegistration() throws InterruptedException {

		registerPage.signupLink.click();
		Thread.sleep(1000);
		registerPage.enterUsername(username);
		registerPage.enterPassword("Demo@123");
		registerPage.clickSignup();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		logWithScreenshot("User successfully signed up");
		logger.pass("User registered successfully");
	}

}
