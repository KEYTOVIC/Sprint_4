package PageObgect;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Локаторы для кнопок заказа
    private By orderButtonTop = By.className("Button_Button__ra12g"); // Верхняя кнопка
    private By orderButtonBottom = By.className("Button_Button__ra12g"); // Нижняя кнопка

    // Локаторы для заполнения заказа
    private By fieldName = By.xpath("//input[@placeholder='* Имя']");
    private By fieldSurname = By.xpath("//input[@placeholder='* Фамилия']");
    private By orderAdress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStation = By.className("select-search__input");
    private By metroStationSocolniki = By.xpath("//div[text()='Сокольники']");
    private By metroLubyanka = By.xpath("//*[text()='Лубянка']");
    private By clientNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    // Для заполнения 2 страницы заказа
    private By textArenda = By.xpath(".//div[text()='Про аренду']");
    private By fieldDeliverScooter = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By fieldRentalPeriod = By.className("Dropdown-placeholder");
    private By fieldFourDays = By.xpath("//div[text()='двое суток']");
    private By fieldTwoDays = By.xpath("//div[text()='четверо суток']");
    private By fieldBlack = By.id("black");
    private By fieldGrey = By.id("grey");
    private By fieldComment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    // Кнопка заказать
    private By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Проверка всплывающего окна
    private By textWouldOrder = By.xpath("//div[text()='Хотите оформить заказ?']");
    private By buttonYes = By.xpath("//button[text()='Да']");
    private By orderCreated = By.xpath("//div[text()='Заказ оформлен']");

    public void clickOrderButtonTop() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonTop)).click();
    }

    public void fillFirstOrderFormTop(String name, String surname, String address, String metro, String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldName)).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(fieldSurname)).sendKeys(surname);
        wait.until(ExpectedConditions.elementToBeClickable(orderAdress)).sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(metroStation)).sendKeys(metro);
        wait.until(ExpectedConditions.elementToBeClickable(metroStationSocolniki)).click();
        wait.until(ExpectedConditions.elementToBeClickable(clientNumber)).sendKeys(phone);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    public void fillFirstOrderFormBottom(String name, String surname, String address, String metro, String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldName)).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(fieldSurname)).sendKeys(surname);
        wait.until(ExpectedConditions.elementToBeClickable(orderAdress)).sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(metroStation)).sendKeys(metro);
        wait.until(ExpectedConditions.elementToBeClickable(metroLubyanka)).click();
        wait.until(ExpectedConditions.elementToBeClickable(clientNumber)).sendKeys(phone);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    public void fillLastOrderForm(String date, String comment) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldDeliverScooter)).sendKeys(date);
        wait.until(ExpectedConditions.elementToBeClickable(fieldComment)).sendKeys(comment);
    }

    public void clickTextArenda() {
        wait.until(ExpectedConditions.elementToBeClickable(textArenda)).click();
    }

    public void clickFieldRentalPeriod() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldRentalPeriod)).click();
    }

    public void clickFieldFourDays() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldFourDays)).click();
    }

    public void clickFieldTwoDays() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldTwoDays)).click();
    }

    public void clickFieldBlack() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldBlack)).click();
    }
    public void clickFieldGrey() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldGrey)).click();
    }

    public void clickButtonOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonOrder)).click();
    }

    public boolean watTextWouldOrder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textWouldOrder)).isDisplayed();
    }

    public void clickButtonYes() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonYes)).click();
    }

    public void clickOrderButtonBottom() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonBottom)).click();
    }

}