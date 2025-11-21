import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public HomePage login(WebDriver driver) throws InterruptedException {
        By emailBox = By.id("login-email");
        driver.findElement(emailBox).sendKeys("asddasdaasd@dasd.com");

        By passwordBox = By.id("login-password-input");
        driver.findElement(passwordBox).sendKeys("1234qwe");

        closeCookieAlert(driver);

        By submitButton = By.className("submit");
        driver.findElement(submitButton).click();
        Thread.sleep(1000);

        //**
        // 1- Thread.sleep: antipattern
        // 2- implicitlyWait --webdriver'a sabit bir timeout tanımlamak
        // 3- explicitlyWait -- best practice
        ///

        return new HomePage();
    }

    public void closeCookieAlert(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        try {
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        } catch (Exception ex) {
            return;
        }
    }
}
