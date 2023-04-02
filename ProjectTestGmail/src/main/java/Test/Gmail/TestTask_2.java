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

public class TestTask_2 {

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
            // Вводим данные поля "логин"
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

            // Ожидание, пока кнопка "Написать" не появится
            WebElement WriteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='T-I T-I-KE L3']")));
            // Кликаем на кнопку "Написать"
            WriteButton.click();

            // Ожидание, пока появится поле ввода адреса получателя
            WebElement ToField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@class='agP aFw']")));
            // Вводим адрес эл.почты получателя в поле "Кому?"
            ToField.sendKeys("dmitriy.yegorov.02@gmail.com");

            // Ожидание, пока появится поле ввода текста письма
            WebElement LetterBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Текст письма']")));
            // Ввод в поле "текст письма"
            LetterBody.sendKeys("Тестовое письмо!");

            // Ожидание, пока кнопка "Отправить" не станет кликабельной
            WebElement SendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")));
            // Клик по кнопке "Отправить"
            SendButton.click();

            // Вывод сообщения об успешной/неуспешной отправки письма
            System.out.println("Отправка письма прошла успешно!");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            try { //Ожидание закрытие браузера, для отправки письма
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}

