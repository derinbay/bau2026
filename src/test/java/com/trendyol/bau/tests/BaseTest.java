package com.trendyol.bau.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    WebDriverWait wait10;

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    void startUp() {
        driver.set(new ChromeDriver());

        getDriver().get("https://www.trendyol.com");
        wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    @AfterMethod
    void tearDown() {
        getDriver().quit();
    }
}
