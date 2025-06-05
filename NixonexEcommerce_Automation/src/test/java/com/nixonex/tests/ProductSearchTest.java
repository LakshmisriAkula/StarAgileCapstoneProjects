package com.nixonex.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nixonex.base.TestBase;
import com.nixonex.pages.CartPage;
import com.nixonex.pages.ProductPage;

public class ProductSearchTest extends TestBase {
	ProductPage productPage;
	CartPage cartPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);

	}

	@Test
	public void testBrowseAndSelectProduct() throws InterruptedException {

		productPage.selectCategory("Laptops");
		Thread.sleep(1000);

		productPage.selectProduct("Sony vaio i5");
		Thread.sleep(2000);

		productPage.addToCartButton.click();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		cartPage.cartLink.click();

		Thread.sleep(2000);

		logWithScreenshot("Product added to cart");

	}

}
