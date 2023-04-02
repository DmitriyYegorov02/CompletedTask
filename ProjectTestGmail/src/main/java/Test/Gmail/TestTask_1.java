package Test.Gmail;
//Импорты для работы кода
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestTask_1 {

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
            // Вводим  данные для поля "логин"
            LoginField.sendKeys("testlogin989");

            // Ожидание, пока кнопка "Далее" не станет кликабельной
            WebElement NextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Далее']")));
            // Клик по кнопке "Далее"
            NextButton.click();

            // Ожидание, пока поле ввода пароля не появится
            WebElement PasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
            //Вводим  данные для поля "пароль"
            PasswordField.sendKeys("test98900");

            // Заново ищем кнопку "Далее"
            NextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Далее']")));
            // Клик по кнопке "Далее"
            NextButton.click();

            // Убеждаемся, что почта открылась, ожидание, пока кнопка "Входящие" не появится
            WebElement IncomingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TN bzz aHS-bnt']")));
            // Клик по кнопке "Входящие"
            IncomingButton.click();

            // Вывод сообщение об успешной/неуспешной авторизации
            System.out.println("Авторизация успешно пройдена!");

        } catch (Exception e) {
            System.out.println("Ошибка авторизации: " + e.getMessage());
        } finally {

            // Закрываем браузер
            driver.quit();
        }
    }
}
