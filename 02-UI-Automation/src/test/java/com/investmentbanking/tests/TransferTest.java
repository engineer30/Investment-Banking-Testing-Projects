package com.investmentbanking.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.investmentbanking.pages.LoginPage;
import com.investmentbanking.pages.TransferPage;

public class TransferTest {

    WebDriver driver;
    LoginPage loginPage;
    TransferPage transferPage;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        loginPage = new LoginPage(driver);
        transferPage = new TransferPage(driver);

        // Login
        loginPage.login("john", "demo");
    }

    @Test
    public void transferFundsTest() {

        // Open Transfer Funds page
        transferPage.openTransferFunds();

        // Enter transfer amount
        transferPage.enterAmount("100");

        // Click Transfer
        transferPage.clickTransfer();

        System.out.println("Fund transfer operation completed!");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("transfer"),
                "Transfer Funds page was not opened"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}