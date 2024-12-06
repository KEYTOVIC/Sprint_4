package PageObgect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void scrollToElement() {
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestionPageNumber(int number) {
        By questionPageNumber = By.id("accordion__heading-" + number);
        wait.until(ExpectedConditions.elementToBeClickable(questionPageNumber)).click();
    }

    public boolean isAnswerToTheQuestion(int number) {
        By answerToTheQuestion = By.id("accordion__panel-" + number);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerToTheQuestion)).isDisplayed();
    }
}