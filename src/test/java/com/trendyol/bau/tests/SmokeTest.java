package com.trendyol.bau.tests;

import com.trendyol.bau.DataObjects.User;
import com.trendyol.bau.PageObjects.HomePage;
import com.trendyol.bau.PageObjects.LoginPage;
import com.trendyol.bau.PageObjects.SearchResultPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SmokeTest extends BaseTest {

    //*
    // 1- Test data
    // 2- Browser action
    // 3- Assertion
    // *

    //*
    // In A test class
    // - There should be only test methods @Test
    // *

    @Test
    void testLogo() {
        HomePage homePage = new HomePage(getDriver(), getWait());
        WebElement logoElement = homePage.getLogoElement();
        assertTrue(logoElement.isDisplayed());
    }

    @Test
    void testSearch() {
        String searchText = "Laptop";
        HomePage homePage = new HomePage(getDriver(), getWait());
        homePage.closeModal();
        SearchResultPage searchResultPage = homePage.search(searchText);

        WebElement productCardElement = searchResultPage.getProduct();
        assertTrue(productCardElement.isDisplayed());
    }

    @Test
    void testKadinTab() {
        String attributeName = "class";
        HomePage homePage = new HomePage(getDriver(), getWait());
        homePage.closeModal();
        homePage.clickKadinCategory();

        String cssValue = homePage.getAttribute(attributeName);
        assertTrue(cssValue.contains("active"));
    }

    @Test
    public void testLogin() {
        User user = new User("asddasdaasd@dasd.com", "1234qwe");

        HomePage homePage = new HomePage(getDriver(), getWait());
        homePage.closeModal();

        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(user.getEmail(), user.getPassword());

        homePage.waitUntilPageLoad();
        String myAccountContainerText = homePage.getMyAccountContainerText();
        Assert.assertEquals(myAccountContainerText, "Hesabım");
    }

    //
    // 1- Rename the classes
    // 2- Created BasePage class and move
    // 3- created wait objects
    // 4- moved all non test methods to page objects and base classes
    // 5-
    // *

    // Homework for 19.12.2025
    // 1- check for impilictlyWait
    // 2- make explicitylyWait objects thread safe
    // 3- check response codes
}
