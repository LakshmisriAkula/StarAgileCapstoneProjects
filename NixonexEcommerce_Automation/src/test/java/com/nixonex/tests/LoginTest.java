package com.nixonex.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nixonex.base.TestBase;
import com.nixonex.pages.LoginPage;

public class LoginTest extends TestBase {
    LoginPage loginPage;
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
	}

    @Test
    public void testValidLogin() throws InterruptedException {
        loginPage.loginLink.click();
        Thread.sleep(1000);  // Wait for modal
        loginPage.enterUsername("Lakshmisri");
        loginPage.enterPassword("Demo@123");
        loginPage.clickLogin();
        
        Thread.sleep(5000);  // Wait for login to process
        
        logWithScreenshot("Login Successful");

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
    }

   
}

