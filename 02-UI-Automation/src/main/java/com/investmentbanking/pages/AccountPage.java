package com.investmentbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver driver;

    // Accounts Overview heading
    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    WebElement accountsOverview;

    // Constructor
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Assertion/verification
    public boolean isAccountsOverviewDisplayed() {
        return accountsOverview.isDisplayed();
    }
}