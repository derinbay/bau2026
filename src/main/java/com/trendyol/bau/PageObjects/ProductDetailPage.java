package com.trendyol.bau.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

    By addToCartButton = By.cssSelector("[data-testid=add-to-cart-button]");
    By closeAddressWarningButton = By.cssSelector(".onboarding-popover button");

    public ProductDetailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CartRecommendationPage addToCart() {
        click(addToCartButton);
        return new CartRecommendationPage(driver, wait);
    }

    public void closeAddressWarning() {
        click(closeAddressWarningButton);
    }
}
