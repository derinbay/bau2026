package com.trendyol.bau.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartRecommendationPage extends BasePage {

    By successfullyAddContainer = By.className("product-preview-container");

    public CartRecommendationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isSuccessfulAddContainerDisplayed() {
        return findElement(successfullyAddContainer).isDisplayed();
    }
}
