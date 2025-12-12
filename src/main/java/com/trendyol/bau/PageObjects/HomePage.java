package com.trendyol.bau.PageObjects;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    By tab = By.className("tab-link");
    By logo = By.id("logo");
    By myAccountContainer = By.className("account-user");
    By searchBox = By.cssSelector("[data-testid=suggestion]");
    By searchIcon = By.cssSelector("[data-testid=search-icon]");
    By modalCloseButton = By.className("modal-section-close");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLogoElement() {
        return findElement(logo);
    }

    public LoginPage clickLogin() {
        click(myAccountContainer);
        return new LoginPage(driver, wait);
    }

    public SearchResultPage search(String searchText) {
        sendKeys(searchBox, searchText);
        click(searchIcon);

        return new SearchResultPage(driver, wait);
    }

    public String getMyAccountContainerText() {
        return getText(myAccountContainer);
    }

    public void closeModal() {
        click(modalCloseButton);
    }

    public void clickKadinCategory() {
        click(tab);
    }

    public String getAttribute(String attributeName) {
        return findElement(tab).getAttribute(attributeName);
    }

    public void waitUntilPageLoad() {
        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/"));
    }
}
