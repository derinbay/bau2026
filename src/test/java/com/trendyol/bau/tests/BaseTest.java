package com.trendyol.bau.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }
    public static WebDriverWait getWait() {
        return wait.get();
    }
    @BeforeMethod
    void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");

        driver.set(new ChromeDriver(options));
        getDriver().get("https://www.trendyol.com");
        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
    }

    @AfterMethod
    void tearDown() {
        getDriver().quit();
    }
}
