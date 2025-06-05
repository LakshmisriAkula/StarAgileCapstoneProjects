package com.nixonex.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nixonex.base.TestBase;
import com.nixonex.pages.CartPage;
import com.nixonex.pages.CheckoutPage;
import com.nixonex.pages.ConfirmationPage;
import com.nixonex.pages.LoginPage;
import com.nixonex.pages.ProductPage;
import com.nixonex.pages.RegisterPage;

public class EndToEndTest extends TestBase {
	RegisterPage registerPage;
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confirmationPage;

	String username = "user" + System.currentTimeMillis(); // Unique username

	@BeforeMethod
	public void setUp() {
		initialization();
		registerPage = new RegisterPage(driver);
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		confirmationPage = new ConfirmationPage(driver);
	}

	@Test

	public void nixonnexEndToEndTest() throws InterruptedException {
		testUserRegistration();
		testLogin();
		testProductSearchAndAddToCart();
		testCheckoutAndConfirmation();

	}

	public void testUserRegistration() throws InterruptedException {
		registerPage.signupLink.click();
		Thread.sleep(1000);
		registerPage.enterUsername(username);
		registerPage.enterPassword("Demo@123");
		registerPage.clickSignup();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		logger.pass("User registered successfully");

	}

	public void testLogin() throws InterruptedException {
		loginPage.loginLink.click();
		Thread.sleep(1000);
		loginPage.enterUsername("Lakshmisri");
		loginPage.enterPassword("Demo@123");
		loginPage.clickLogin();
		Thread.sleep(5000);
		logWithScreenshot("Login Successful");
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed in end-to-end test.");
	}

	public void testProductSearchAndAddToCart() throws InterruptedException {
		productPage.selectCategory("Monitors");
		Thread.sleep(1000);
		productPage.selectProduct("Apple monitor 24");
		Thread.sleep(2000);
		productPage.addToCartButton.click();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		cartPage.cartLink.click();

		Thread.sleep(2000);

		logWithScreenshot("Product added to cart");

	}

	public void testCheckoutAndConfirmation() throws InterruptedException {

		cartPage.placeOrderButton.click();
		Thread.sleep(1000);
		checkoutPage.enterName("Lakshmisri");
		checkoutPage.enterCountry("US");
		checkoutPage.enterCity("Michigan");
		checkoutPage.enterCard("1111222233334444");
		checkoutPage.enterMonth("06");
		checkoutPage.enterYear("2025");
		checkoutPage.purchaseButton.click();
		Thread.sleep(2000);
		Assert.assertTrue(confirmationPage.isConfirmationDisplayed(), "Confirmation not shown!");
		System.out.println("🧾 Order Details: \n" + confirmationPage.getOrderDetails());
		Thread.sleep(1500);
		logWithScreenshot("After clicking checkout");
		confirmationPage.okButton.click();
	}

}
