package com.investmentbanking.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.investmentbanking.pages.AccountPage;
import com.investmentbanking.pages.LoginPage;

public class AccountTest {

    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        // Login
        loginPage.login("john", "demo");
    }

    @Test
    public void verifyAccountsOverview() {

        Assert.assertTrue(accountPage.isAccountsOverviewDisplayed(),
                "Accounts Overview page is not displayed");

        System.out.println("Accounts Overview page displayed successfully!");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}