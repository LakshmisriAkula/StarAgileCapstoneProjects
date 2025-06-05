package com.nixonex.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	@FindBy(css = ".list-group a")
	public List<WebElement> categoryList;

	@FindBy(css = ".card-title a")
	public List<WebElement> productItems;

	@FindBy(css = ".btn-success")
	public WebElement addToCartButton;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCategory(String categoryName) {

		for (WebElement category : categoryList) {
			if (category.getText().equalsIgnoreCase(categoryName)) {
				category.click();
				break;
			}
		}
	}

	public void selectProduct(String productName) {

		for (WebElement product : productItems) {
			if (product.getText().equalsIgnoreCase(productName)) {
				product.click();
				break;
			}
		}
	}

}
