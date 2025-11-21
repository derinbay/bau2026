import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebElement getLogoElement(WebDriver driver) {
        By logo = By.id("logo");
        return driver.findElement(logo);
    }

    public LoginPage clickLogin(WebDriver driver) {
        By myAccountContainer = By.className("account-user");
        driver.findElement(myAccountContainer).click();

        return new LoginPage();
    }

    public SearchResultPage search(WebDriver driver) {
        By searchBox = By.className("vQI670rJ");
        driver.findElement(searchBox)
                .sendKeys("laptop");

        By searchIcon = By.className("ft51BU2r");
        driver.findElement(searchIcon).click();

        return new SearchResultPage();
    }

    public String getMyAccountContainerText(WebDriver driver) {
        By myAccountContainer = By.className("link-text");
        return driver.findElement(myAccountContainer).getText();
    }

    public void closeModal(WebDriver driver) {
        By modalCloseButton = By.className("modal-section-close");
        driver.findElement(modalCloseButton).click();
    }

    public void clickKadinCategory(WebDriver driver) {
        By tab = By.className("tab-link");
        driver.findElement(tab).click();
    }

    public String getAttribute(WebDriver driver) {
        return driver.findElement(By.className("tab-link")).getAttribute("class");
    }
}
