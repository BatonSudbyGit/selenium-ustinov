package ru.ibs.appline.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainingApplineTest {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1000));
    String login = "Taraskina Valeriya";
    String password = "testing";

    @BeforeEach
    public void before() {
        //Шаг 1. Переход на страницу авторизации
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver114.exe");
        driver.get("http://training.appline.ru/user/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1920,1080));
    }

    @Test()
    public void test() {
        //Шаг 2. Авторизация
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(login);
        driver.findElement(By.name("_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space('Войти')]")).click();

        //Шаг 3. Проверить наличие на странице заголовка 'Панель быстрого запуска'
        assertTrue(driver.findElement(By.xpath("//h1[text()='Панель быстрого запуска']")).isDisplayed(),
                "На странице отсутствует заголовок 'Панель быстрого запуска'");

        //Шаг 4. В выплывающем окне раздела 'Расходы' нажать на 'Командировки'
        WebElement costsList = driver.findElement(By.xpath(
                "//ul[contains(@class,'main-menu')]/li/a/span[@class='title' and text()='Расходы']"));
        costsList.click();
        wait.until(ExpectedConditions.visibilityOf(costsList.findElement(By.xpath(
                "./ancestor::li//ul[@class='dropdown-menu menu_level_1']"))));
        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        loading();

        //Шаг 5. Нажать на 'Создать командировку'
        driver.findElement(By.xpath("//a[@title='Создать командировку']")).click();
        loading();

        //Шаг 6. Проверить наличие на странице заголовка 'Создать командировку'
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='row']//h1[@class='user-name']"))));

        //Шаг 7. На странице создания командировки заполнить или выбрать поля:
            //— Подразделение - выбрать Отдел внутренней разработки
            //— Принимающая организация - нажать 'Открыть список' и в поле 'Укажите организацию' выбрать любое значение
            //— В задачах поставить чекбокс на 'Заказ билетов'
            //— Указать города выбытия и прибытия
            //— Указать даты выезда и возвращения
            //— !! Раздел Командированные сотрудники не заполнять
        WebElement mainInformationBlocks = driver.findElement(By.xpath(
                "//div[contains(@class,'responsive-cell responsive-cell-no-blocks')]"));

        WebElement choiceBlock = mainInformationBlocks.findElement(By.xpath(
                "//div[contains(@class,'control-group')]"));

        WebElement unitBlock = choiceBlock.findElement(By.xpath(
                "//select[contains(@id,'crm_business_trip_businessUnit')]/."));

        unitBlock.click();
        unitBlock.findElement(By.xpath("./option[text()='Отдел внутренней разработки']")).click();
        unitBlock.click();
        mainInformationBlocks.findElement(By.xpath("//a[text()='Открыть список']")).click();

        WebElement organisationBlock = choiceBlock.findElement(By.xpath("//div[contains(@class,'select2-container')]"));
        organisationBlock.click();

        WebElement organisationDropDownList = driver.findElement(By.xpath("//div[contains(@class,'select2-drop')]"));
        organisationDropDownList.findElement(By.xpath(
                "//div[contains(text(),'(Хром) Призрачная Организация Охотников')]")).click();

        WebElement tasksBlock = mainInformationBlocks.findElement(By.xpath("//label[contains(text(),'Задачи')]/../."));
        tasksBlock.findElement(By.xpath("//label[text()='Заказ билетов']//preceding-sibling::input")).click();

        WebElement departureCityInputField = choiceBlock.findElement(By.xpath(
                "//input[@data-ftid='crm_business_trip_departureCity']"));
        departureCityInputField.clear();
        departureCityInputField.sendKeys("Энгельс");

        WebElement arrivalCityInputField = choiceBlock.findElement(By.xpath(
                "//input[@data-ftid='crm_business_trip_arrivalCity']"));
        arrivalCityInputField.sendKeys("Москва");

        WebElement plannedDepartureDateInputField = choiceBlock.findElement(By.xpath(
                "//input[contains(@id,'departureDatePlan') and contains(@class,'datepicker-input')]"));
        plannedDepartureDateInputField.sendKeys("10.11.2023");

        WebElement plannedReturnDateInputField = choiceBlock.findElement(By.xpath(
                "//input[contains(@id,'returnDatePlan') and contains(@class,'datepicker-input')]"));
        plannedReturnDateInputField.sendKeys("10.12.2023");

        //Шаг 8. Проверить, что все поля заполнены правильно
        //проверка, что подразделение выбрано
        assertTrue(unitBlock.getText().contains("Отдел внутренней разработки"),
                "Блок 'Подразделение' не содержит в себе текст 'Отдел внутренней разработки'");

        //проверка, что организация выбрана
        assertTrue(organisationBlock.getText().contains("(Хром) Призрачная Организация Охотников"),
                "Блок 'Укажите организацию' не содержит в себе текст '(Хром) Призрачная Организация Охотников'");

        //проверка, что чекбокс 'Заказ билетов' поставлен
        assertTrue(tasksBlock.findElement(By.xpath("//label[text()='Заказ билетов']//preceding-sibling::input")).isSelected(),
                "Чекбокс 'Заказ билетов' не поставлен");

        //проверка, что поля Выбытия и Прибытия заполнены
        assertTrue(departureCityInputField.getAttribute("value").contains("Энгельс"),
                "Поле 'Город выбытия' не содержит текст 'Энгельс'");
        assertTrue(arrivalCityInputField.getAttribute("value").contains("Москва"),
                "Поле 'Город прибытия' не содержит текст 'Москва'");

        //проверка, что поля Дата выезда и Дата возвращения заполнены
        assertFalse(plannedDepartureDateInputField.getText().contains("datepicker-input  hasDatepicker error"),
                "Поле 'Планируемая дата выезда' не содержит текст");
        assertFalse(plannedReturnDateInputField.getText().contains("datepicker-input  hasDatepicker error"),
                "Поле 'Планируемая дата возвращения' не содержит текст");

        //Шаг 9. Нажать 'Сохранить и закрыть'
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(
                "//button[@class='btn btn-success action-button']")));
        loading();

        //Шаг 8. Проверить, что на странице появилось сообщение: 'Список командируемых сотрудников не может быть пустым'
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                "//label[text()='Командированные сотрудники']/../..//span[text()='Список командируемых сотрудников не может быть пустым']"))));
        assertTrue(driver.findElement(By.xpath(
                "//label[text()='Командированные сотрудники']/../..//span[text()='Список командируемых сотрудников не может быть пустым']"))
                        .getText()
                        .contains("Список командируемых сотрудников не может быть пустым"),
                "На странице не появилось сообщение: 'Список командируемых сотрудников не может быть пустым'");
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public void loading() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='loader-mask shown']"))));
    }
}
