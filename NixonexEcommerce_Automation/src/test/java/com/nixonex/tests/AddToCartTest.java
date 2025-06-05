package com.nixonex.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nixonex.base.TestBase;
import com.nixonex.pages.CartPage;
import com.nixonex.pages.ProductPage;

public class AddToCartTest extends TestBase {
	ProductPage productPage;
	CartPage cartPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);

	}

	@Test
	public void testAddProductToCart() throws InterruptedException {

		productPage.selectCategory("Laptops");
		Thread.sleep(1000);
		productPage.selectProduct("Dell i7 8gb");
		Thread.sleep(2000);
		productPage.addToCartButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		cartPage.cartLink.click();

		Thread.sleep(2000); // Allow cart to load

		logWithScreenshot("Product added to cart");

		cartPage.clearCart();
		
		Thread.sleep(2000);

		logWithScreenshot("Cart Items Removed");

	}

}
