package com.trendyol.bau.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    By emailBox = By.id("login-email");
    By passwordBox = By.id("login-password-input");
    By submitButton = By.className("submit");
    By acceptCookieButton = By.id("onetrust-accept-btn-handler");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePage login(String email, String password) {
        sendKeys(emailBox, email);
        sendKeys(passwordBox, password);
        click(submitButton);

        return new HomePage(driver, wait);
    }

    public void closeCookieAlert() {
        try {
            click(acceptCookieButton);
        } catch (Exception ex) {
            return;
        }
    }
}
