
package com.investmentbanking.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.investmentbanking.pages.LoginPage;
import com.investmentbanking.pages.LogoutPage;

public class LogoutTest {

    WebDriver driver;

    LoginPage loginPage;
    LogoutPage logoutPage;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Test
    public void verifyLogout() {

        // Login to the application
        loginPage.login("john", "demo");

        // Verify login was successful
        Assert.assertTrue(driver.getCurrentUrl().contains("overview"),
                "Login was not successful");

        // Click Logout
        logoutPage.clickLogout();

        // Verify logout was successful
        Assert.assertTrue(driver.getCurrentUrl().contains("index.htm"),
                "Logout was not successful");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}


