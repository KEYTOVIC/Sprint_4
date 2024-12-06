package tests;

import com.example.config.Config;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObgect.OrderPage;

public class OrderProcessingTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Config.BASE_URL);
        wait = new WebDriverWait(driver, 3);
    }
    /*private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get(Config.BASE_URL);
        wait = new WebDriverWait(driver, 10);
    }*/

    @Test
    @Description("Позитивный кейс оформления заказа с верхней кнопки")
    public void orderTopProcessTests() {
        OrderPage objOrderPage = new OrderPage(driver, wait);

        objOrderPage.clickOrderButtonTop();
        objOrderPage.fillFirstOrderFormTop("Доктор", "Стрэйндж", "177-Лейкер-стрит", "Сокольники", "+76666666666");
        objOrderPage.fillLastOrderForm("20.04.2024", "Побыстрее");
        objOrderPage.clickTextArenda();
        objOrderPage.clickFieldRentalPeriod();
        objOrderPage.clickFieldFourDays();
        objOrderPage.clickFieldBlack();
        objOrderPage.clickButtonOrder();
        objOrderPage.watTextWouldOrder();
        objOrderPage.clickButtonYes();
    }

    @Test
    @Description("Позитивный кейс оформления заказа с нижней кнопки")
    public void orderBottomProcessTests(){
        OrderPage objOrderPage = new OrderPage(driver, wait);

        objOrderPage.clickOrderButtonBottom();
        objOrderPage.fillFirstOrderFormBottom("Тонни", "Старк", "Малибу-Поинт", "Лубянка", "86666666666");
        objOrderPage.fillLastOrderForm("01.02.2023", "Не торопитесь");
        objOrderPage.clickTextArenda();
        objOrderPage.clickFieldRentalPeriod();
        objOrderPage.clickFieldTwoDays();
        objOrderPage.clickFieldGrey();
        objOrderPage.clickButtonOrder();
        objOrderPage.watTextWouldOrder();
        objOrderPage.clickButtonYes();

    }
    @After
    public void teardown() {
        driver.quit();
    }

}
