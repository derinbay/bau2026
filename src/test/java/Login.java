import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com");
        driver.findElement(By.className("modal-section-close")).click();
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    void login() {
        WebElement loginButton = driver.findElement(By.className("user-login-container"));
        loginButton.click();

        WebElement emailInput = driver.findElement(By.id("login-email"));
        emailInput.sendKeys(Config.getTrendyolEmail());

        WebElement passwordInput = driver.findElement(By.id("login-password-input"));
        passwordInput.sendKeys(Config.getTrendyolPassword());

        WebElement loginButton2 = driver.findElement(By.cssSelector(".submit"));
        loginButton2.click();

        // added wait... the absence of this leads to test failure since selenium executes commands too quickly
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.className("link-text"), "Hesabım"));

        Assert.assertEquals(driver.findElement(By.className("link-text")).getText(), "Hesabım");
    }
}
