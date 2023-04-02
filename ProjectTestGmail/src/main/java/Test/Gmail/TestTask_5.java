package Test.Gmail;
//Импорты для работы кода
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestTask_5 {

    public static void main(String[] args) {

        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //Создаем настройки WebDriver для Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // Устанавливаем явное ожидание в 10 секунд
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Открываем страницу Gmail
            driver.get("https://www.gmail.com");

            // Ожидание, пока появится ввод поля "логин"
            WebElement LoginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
            // Вводим валидные поля "логин"
            LoginField.sendKeys("testlogin989");

            // Ожидание, пока кнопка "Далее" не станет кликабельной
            WebElement NextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Далее']")));
            // Клик по кнопке "Далее"
            NextButton.click();

            // Ожидание, пока поле ввода пароля не появится
            WebElement PasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
            //Вводим данные для поля "пароль"
            PasswordField.sendKeys("test98900");

            // Ищем кнопку "Далее" заново
            NextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Далее']")));
            // Клик по кнопке "Далее"
            NextButton.click();

            // Ожидание, пока кнопка "Отправленные" не станет кликабельной
            WebElement SentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Отправленные']")));
            // Клик по кнопке "Отправленые"
            SentButton.click();

            // Ожидание, пока элемент отправленного письма не станет кликабельной
            WebElement SentLetterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='-- SIGNATURE']")));
            // Клик по по элементу отправленного письма
            SentLetterButton.click();

            // Поверка присутствия подписи на странице
            boolean isTextPresent = driver.getPageSource().contains("SIGNATURE");

            if (isTextPresent) {
                System.out.println("Подпись присутствует  в письме");
            } else {
                System.out.println("Подпись отсутствует в письме");
            }

            // Вывод сообщение об успешной/неуспешной авторизации
            System.out.println("Проверка отправленного письма с подписью прошла успешно!");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            try { //Ожидание закрытие браузера, убедиться что отправленное письмо отображается
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}


