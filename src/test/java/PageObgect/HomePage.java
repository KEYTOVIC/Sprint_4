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

    // Локаторы для вопросов
    private By[] questions = {
            By.xpath("//div[text()='Сколько это стоит? И как оплатить?']"),
            By.xpath("//div[text()='Хочу сразу несколько самокатов! Так можно?']"),
            By.xpath("//div[text()='Как рассчитывается время аренды?']"),
            By.xpath("//div[text()='Можно ли заказать самокат прямо на сегодня?']"),
            By.xpath("//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']"),
            By.xpath("//div[text()='Вы привозите зарядку вместе с самокатом?']"),
            By.xpath("//div[text()='Можно ли отменить заказ?']"),
            By.xpath("//div[text()='Я жизу за МКАДом, привезёте?']")
    };

    // Локаторы для ответов
    private By[] answers = {
            By.xpath("//p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или')]"),
            By.xpath("//p[contains(text(),'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.')]"),
            By.xpath("//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.')]"),
            By.xpath("//p[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем расторопнее.')]"),
            By.xpath("//p[contains(text(),'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.')]"),
            By.xpath("//p[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.')]"),
            By.xpath("//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.')]"),
            By.xpath("//p[contains(text(),'Да, обязательно. Всем самокатов! И Москве, и Московской области.')]")
    };

    public void scrollToElement() {
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public boolean isAnswerToTheQuestion(int number) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answers[number])).isDisplayed();
    }

    public void clickQuestionPageNumber(int number) {
        wait.until(ExpectedConditions.elementToBeClickable(questions[number])).click();
    }

    public boolean verifyQuestionAndAnswer(int number) {
        // Прокрутка к вопросу
        WebElement questionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(questions[number]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionElement);

        // Клик по вопросу
        clickQuestionPageNumber(number);

        // Проверка ответа
        return isAnswerToTheQuestion(number);
    }
}