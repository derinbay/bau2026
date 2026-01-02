package com.trendyol.bau.PageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.trendyol.bau.BaseTest.getDriver;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public void sendKeys(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public void switchToNextWindow() {
        Set<String> allHandles = getDriver().getWindowHandles();
        String currentWindow = getCurrentWindowHandle();

        for (String handle : allHandles) {
            if (!handle.equals(currentWindow)) {
                getDriver().switchTo().window(handle);
            }
        }
    }

    public String getCurrentWindowHandle() {
        return getDriver().getWindowHandle();
    }
}
