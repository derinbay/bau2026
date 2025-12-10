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
        HomePage homePage = new HomePage(driver, wait10);
        WebElement logoElement = homePage.getLogoElement();
        assertTrue(logoElement.isDisplayed());
    }

    @Test
    void testSearch() {
        String searchText = "Search";
        HomePage homePage = new HomePage(driver, wait10);
        homePage.closeModal();
        SearchResultPage searchResultPage = homePage.search(searchText);

        WebElement productCardElement = searchResultPage.getProduct();
        assertTrue(productCardElement.isDisplayed());
    }

    @Test
    void testKadinTab() {
        String attributeName = "class";
        HomePage homePage = new HomePage(driver, wait10);
        homePage.closeModal();
        homePage.clickKadinCategory();

        String cssValue = homePage.getAttribute(attributeName);
        assertTrue(cssValue.contains("active"));
    }

    @Test
    public void testLogin() {
        User user = new User("asddasdaasd@dasd.com", "1234qwe");

        HomePage homePage = new HomePage(driver, wait10);
        homePage.closeModal();

        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login(user.getEmail(), user.getPassword());

        homePage.waitUntilPageLoad();
        String myAccountContainerText = homePage.getMyAccountContainerText();
        Assert.assertEquals(myAccountContainerText, "Hesabım");
    }

    //Create suite
    //Parallel execution
}
