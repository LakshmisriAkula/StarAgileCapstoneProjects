package com.qa.pages;

ppackage pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminPage {
    WebDriver driver;

    @FindBy(id = "menu_admin_viewAdminModule")
    WebElement adminTab;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    List<WebElement> leftMenuOptions;

    @FindBy(id = "searchSystemUser_userName")
    WebElement usernameField;

    @FindBy(id = "searchSystemUser_userType")
    WebElement userRoleDropdown;

    @FindBy(id = "searchSystemUser_status")
    WebElement statusDropdown;

    @FindBy(id = "searchBtn")
    WebElement searchButton;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
    List<WebElement> resultRows;

    @FindBy(id = "resetBtn")
    WebElement resetButton;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAdminTab() {
        adminTab.click();
    }

    public int getMenuOptionsCount() {
        return leftMenuOptions.size();
    }

    public void searchByUsername(String uname) {
        usernameField.clear();
        usernameField.sendKeys(uname);
        searchButton.click();
    }

    public void searchByUserRole(String role) {
        Select roleSelect = new Select(userRoleDropdown);
        roleSelect.selectByVisibleText(role);
        searchButton.click();
    }

    public void searchByStatus(String status) {
        Select statusSelect = new Select(statusDropdown);
        statusSelect.selectByVisibleText(status);
        searchButton.click();
    }

    public int getResultCount() {
        return resultRows.size();
    }

    public void resetSearch() {
        resetButton.click();
    }
}

