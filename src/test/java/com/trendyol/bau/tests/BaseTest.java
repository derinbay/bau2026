package com.trendyol.bau.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait5;
    WebDriverWait wait10;
    WebDriverWait wait15;

    @BeforeMethod
    void startUp() {
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com");
        wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait15 = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
