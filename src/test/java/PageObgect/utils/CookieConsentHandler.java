package PageObgect.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookieConsentHandler {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cookieBanner = By.className("App_CookieConsent__1yUIN");
    private By closeButton = By.tagName("button");

    public CookieConsentHandler(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void closeCookieConsentBanner() {
        try {
            WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(cookieBanner));
            banner.findElement(closeButton).click();
        } catch (Exception e) {
            // Если баннер не найден, продолжаем выполнение теста
        }
    }
}