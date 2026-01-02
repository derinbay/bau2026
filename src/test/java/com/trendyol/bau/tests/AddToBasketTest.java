package com.trendyol.bau.tests;

import com.trendyol.bau.BaseTest;
import com.trendyol.bau.DataObjects.User;
import com.trendyol.bau.PageObjects.CartRecommendationPage;
import com.trendyol.bau.PageObjects.HomePage;
import com.trendyol.bau.PageObjects.LoginPage;
import com.trendyol.bau.PageObjects.ProductDetailPage;
import com.trendyol.bau.PageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToBasketTest extends BaseTest {

    //*
    // Acceptance criteria: Login olmuş bir kullanıcı, anasayfadan kitap aramasında gelen ilk ürüne gider.
    // Bunu ürün detay sayfasından sepetine ekler.
    // Sepetinde ürünün geldiğini görür
    //
    // 1- login olur
    // 2- "kitap" keyworduyle search yapar
    // 3- search result sayfasındaki ilk ürüne tıklar
    // 4- ürün detay sayfasında sepete ekler
    // 5- sepetime gider
    // 6- ürünün sepetinde olduğunu kontrol eder
    // /

    @Test
    public void testAddToBasket() {
        User user = new User("asddasdaasd@dasd.com", "1234qwe");
        String searchText = "kitap";

        HomePage homePage = new HomePage(getDriver(), getWait());
        homePage.closeModal();

        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(user.getEmail(), user.getPassword());

        homePage.waitUntilPageLoad();
        homePage.closeModal();
        SearchResultPage searchResultPage = homePage.search(searchText);

        ProductDetailPage productDetailPage = searchResultPage.getProductDetailPage();
        productDetailPage.closeAddressWarning();
        CartRecommendationPage cartRecommendationPage = productDetailPage.addToCart();

        Assert.assertTrue(cartRecommendationPage.isSuccessfulAddContainerDisplayed());
    }
}
