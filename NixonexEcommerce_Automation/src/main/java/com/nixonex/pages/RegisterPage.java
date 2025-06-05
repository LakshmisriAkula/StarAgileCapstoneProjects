package com.nixonex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    
    @FindBy(id = "signin2")
	public WebElement signupLink;
    
    @FindBy(id = "sign-username")
    public WebElement signupUsername;
    
    @FindBy(id = "sign-password")
    public WebElement signupPassword;
    
    @FindBy(xpath = "//button[text()='Sign up']")
    public WebElement signupButton;
    
  
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }


    public void enterUsername(String username) {
        signupUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        signupPassword.sendKeys(password);
    }

    public void clickSignup() {
        signupButton.click();
    }
}
