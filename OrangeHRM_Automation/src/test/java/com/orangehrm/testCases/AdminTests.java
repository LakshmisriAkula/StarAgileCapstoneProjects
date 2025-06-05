package com.orangehrm.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.base.TestBase;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.LoginPage;

public class AdminTests extends TestBase {
	LoginPage login;
	AdminPage adminPage;
	ExtentReports report;

	@BeforeMethod
	public void setup() {
		initialization();
		login = new LoginPage(driver);
		adminPage = new AdminPage(driver);
		login.login("Admin", "admin123");
	}

	@Test
	public void adminTestCases() throws InterruptedException {
		verifyMenuCount();
		searchByUsername();
		searchByUserRole();
		searchByStatus();

	}

	public void verifyMenuCount() {
		System.out.println(adminPage.getMenuOptionsCount());
	}

	public void searchByUsername() throws InterruptedException {

		adminPage.adminMenu.click();
		int result = adminPage.searchByUserName("Admin");
		logWithScreenshot("Records found by searching with user name Admin");
		System.out.println("Result by searching with username " + result);
		Assert.assertTrue(result > 0);
		driver.navigate().refresh();
	}

	public void searchByUserRole() throws InterruptedException {
		adminPage.adminMenu.click();
		int result = adminPage.searchByUserRole("Admin");
		logWithScreenshot("Records found by searching with role Admin");
		System.out.println("Result by searching with user role " + result);
		Assert.assertTrue(result > 0);
		driver.navigate().refresh();
	}

	public void searchByStatus() throws InterruptedException {
		adminPage.adminMenu.click();
		int result = adminPage.searchByUserStatus("Enabled");
		logWithScreenshot("Records found by searching with status Enabled");
		System.out.println("Result by searching with status " + result);

		Assert.assertTrue(result > 0);
		driver.navigate().refresh();
	}

}
