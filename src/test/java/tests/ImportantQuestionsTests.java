package tests;

import com.example.config.Config;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObgect.HomePage;
import PageObgect.utils.CookieConsentHandler;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ImportantQuestionsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private int questionNumber;

    public ImportantQuestionsTests(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0 }, { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }
        });
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Config.BASE_URL);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    @Description("Ответы на вопросы в блоке Вопросы о важном присутствуют")
    public void questionsTest() {
        HomePage objHomePage = new HomePage(driver, wait);
        CookieConsentHandler cookieHandler = new CookieConsentHandler(driver, wait);
        objHomePage.scrollToElement();
        cookieHandler.closeCookieConsentBanner();
        objHomePage.clickQuestionPageNumber(questionNumber);
        assertTrue(objHomePage.isAnswerToTheQuestion(questionNumber));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}