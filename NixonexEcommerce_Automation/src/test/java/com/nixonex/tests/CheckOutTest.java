package com.nixonex.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nixonex.base.TestBase;
import com.nixonex.pages.CartPage;
import com.nixonex.pages.CheckoutPage;
import com.nixonex.pages.ConfirmationPage;
import com.nixonex.pages.ProductPage;

public class CheckOutTest extends TestBase {
	ProductPage productPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confirmationPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		confirmationPage = new ConfirmationPage(driver);
	}

	@Test
	public void testCheckoutProcess() throws InterruptedException {

		productPage.selectCategory("Phones");
		Thread.sleep(1000);
		productPage.selectProduct("Samsung galaxy s6");
		Thread.sleep(2000);
		productPage.addToCartButton.click();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		cartPage.cartLink.click();
		Thread.sleep(2000);
		cartPage.placeOrderButton.click();
		Thread.sleep(1000);

		checkoutPage.enterName("Lakshmisri");
		checkoutPage.enterCountry("India");
		checkoutPage.enterCity("New York");
		checkoutPage.enterCard("1234567812345678");
		checkoutPage.enterMonth("06");
		checkoutPage.enterYear("2025");

		checkoutPage.purchaseButton.click();
		Thread.sleep(2000);

		Assert.assertTrue(confirmationPage.isConfirmationDisplayed(), "Order confirmation not shown!");

		System.out.println("Order Details:\n" + confirmationPage.getOrderDetails());

		Thread.sleep(1500);

		logWithScreenshot("After clicking checkout");

		confirmationPage.okButton.click();
	}

}
