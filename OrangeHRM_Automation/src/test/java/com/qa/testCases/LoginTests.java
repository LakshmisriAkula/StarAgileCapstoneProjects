package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtil;

@Listeners(com.qa.extentreportlistener.ExtentTestListener.class)
public class LoginTests extends TestBase {
	LoginPage login;
	ExtentReports report;
	ExtentTest test;
	String sheetName = "Logindata";

	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage(driver);
	}

	@Test(dataProvider = "LoginData")
	public void loginTestCases(String username, String password) {

		login.login(username, password);

		Assert.assertTrue(LoginPage.profile.isDisplayed());
		
		login.logout();

	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws Exception {
		Object data[][] = TestUtil.getTestData(sheetName);

		return data;
	}
}
