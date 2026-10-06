package com.investmentbanking.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.investmentbanking.pages.LoginPage;
import com.investmentbanking.utils.ExcelUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Listeners;
import com.investmentbanking.listeners.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class LoginTest {
	
	private static final Logger logger =
	        LogManager.getLogger(LoginTest.class);

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
    	
    	    logger.info("Starting Login Test");

    	    String username = ExcelUtils.getCellData(
    	            "src/test/resources/testdata/LoginData.xlsx",
    	            "LoginData",
    	            1,
    	            0);

    	    String password = ExcelUtils.getCellData(
    	            "src/test/resources/testdata/LoginData.xlsx",
    	            "LoginData",
    	            1,
    	            1);

    	    System.out.println("Username from Excel: " + username);
    	    System.out.println("Password from Excel: " + password);

    	    logger.info("Login data successfully read from Excel");

    	    loginPage.login(username, password);

    	    logger.info("Login performed successfully");

    	    String title = driver.getTitle();

    	    System.out.println("Page Title: " + title);

    	    Assert.assertTrue(driver.getCurrentUrl().contains("overview"),
    	            "Login was not successful");

    	    logger.info("Login Test completed successfully");
    	}
    

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
