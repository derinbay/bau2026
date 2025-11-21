import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    public WebElement getProduct(WebDriver driver) {
        By productCard = By.className("product-card");

        return driver.findElement(productCard);
    }
}
