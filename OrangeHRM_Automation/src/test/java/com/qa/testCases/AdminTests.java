package com.qa.testCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AdminPage;
import pages.LoginPage;
import utils.ExtentManager;
import com.aventstack.extentreports.*;

public class AdminTests {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    ExtentReports report;
    ExtentTest test;

    @BeforeTest
    public void setupReport() {
        report = ExtentManager.getReportInstance();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @Test(priority = 1)
    public void verifyMenuCount() {
        test = report.createTest("Verify Menu Count on Left Side");
        adminPage.clickAdminTab();
        int count = adminPage.getMenuOptionsCount();
        test.info("Total menu options found: " + count);
        assert count == 12 : "Expected 12 menu items";
        test.pass("Menu count is correct");
    }

    @Test(priority = 2)
    public void searchByUsername() {
        test = report.createTest("Search by Username");
        adminPage.clickAdminTab();
        adminPage.searchByUsername("Admin");
        int results = adminPage.getResultCount();
        test.info("Records found: " + results);
        assert results > 0 : "No records found";
        adminPage.resetSearch();
        test.pass("Search by username passed");
    }

    @Test(priority = 3)
    public void searchByUserRole() {
        test = report.createTest("Search by User Role");
        adminPage.clickAdminTab();
        adminPage.searchByUserRole("Admin");
        int results = adminPage.getResultCount();
        test.info("Records found: " + results);
        assert results > 0 : "No records found";
        adminPage.resetSearch();
        test.pass("Search by user role passed");
    }

    @Test(priority = 4)
    public void searchByStatus() {
        test = report.createTest("Search by User Status");
        adminPage.clickAdminTab();
        adminPage.searchByStatus("Enabled");
        int results = adminPage.getResultCount();
        test.info("Records found: " + results);
        assert results > 0 : "No records found";
        test.pass("Search by status passed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterTest
    public void flushReport() {
        report.flush();
    }
}
