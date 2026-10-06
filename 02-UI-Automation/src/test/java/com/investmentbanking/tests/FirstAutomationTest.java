package com.investmentbanking.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstAutomationTest {

    @Test
    public void openWebsite() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        System.out.println("Website opened successfully!");

        driver.quit();
    }
}
