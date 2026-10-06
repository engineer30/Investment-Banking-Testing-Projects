package com.investmentbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver driver;

    // Logout link
    @FindBy(linkText = "Log Out")
    WebElement logoutLink;

    // Constructor
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Action
    public void clickLogout() {
        logoutLink.click();
    }
}