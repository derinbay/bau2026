import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @BeforeMethod
    void startUp() {
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    void testLogo() {
        HomePage homePage = new HomePage();
        WebElement logoElement = homePage.getLogoElement(driver);
        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    void testSearch() {
        HomePage homePage = new HomePage();
        homePage.closeModal(driver);
        SearchResultPage searchResultPage = homePage.search(driver);

        WebElement productCardElement = searchResultPage.getProduct(driver);
        Assert.assertTrue(productCardElement.isDisplayed());
    }

    @Test
    void testKadin() {
        HomePage homePage = new HomePage();
        homePage.closeModal(driver);
        homePage.clickKadinCategory(driver);
        String cssValue = homePage.getAttribute(driver);

        Assert.assertTrue(cssValue.contains("active"));
    }

    //homework: login scenario
    @Test
    public void login() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.closeModal(driver);

        //user redirecting to login page
        LoginPage loginPage = homePage.clickLogin(driver);
        homePage = loginPage.login(driver);
        String myAccountContainerText = homePage.getMyAccountContainerText(driver);

        Assert.assertEquals(myAccountContainerText, "Hesabım");
    }
}


   //implement explicitWait methods into webdriver methods

