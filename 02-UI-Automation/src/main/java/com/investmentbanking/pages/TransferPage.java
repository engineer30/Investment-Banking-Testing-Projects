package com.investmentbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferPage {

    WebDriver driver;

    // Transfer Funds menu
    @FindBy(xpath = "//a[contains(text(),'Transfer Funds')]")
    WebElement transferFunds;

    // Amount field
    @FindBy(id = "amount")
    WebElement amount;

    // Transfer button
    @FindBy(xpath = "//input[@value='Transfer']")
    WebElement transferButton;

    // Constructor
    public TransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void openTransferFunds() {
        transferFunds.click();
    }

    public void enterAmount(String value) {
        amount.sendKeys(value);
    }

    public void clickTransfer() {
        transferButton.click();
    }
}