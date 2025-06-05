package com.nixonex.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(id="cartur")
    public WebElement cartLink;
    
    @FindBy(xpath="//a[text()='Delete']")
    public List<WebElement> deleteLinks;
    
    @FindBy(xpath="//button[text()='Place Order']")
    public WebElement placeOrderButton;
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clearCart() {
    	
        for (WebElement link : deleteLinks) {
            link.click();
        }
    }

}
