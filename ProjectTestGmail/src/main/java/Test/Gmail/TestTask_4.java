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
import org.openqa.selenium.support.ui.Select;

public class TestTask_4 {

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

            // Ожидание, пока кнопка "Настройки" не станет кликабельной
            WebElement SettingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='FH']")));
            // Клик по кнопке "Настройки"
            SettingButton.click();

            // Ожидание, пока кнопка "Все настройки" не станет кликабельной
            WebElement SettingButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Tj']")));
            // Клик по кнопке "Все настройки"
            SettingButton2.click();

            // Ожидание, пока кнопка "Создать" не станет кликабельной
            WebElement ButtonCreateSignature = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='P5']")));
            // Клик по кнопке "Создать"
            ButtonCreateSignature.click();

            // Ожидание, пока поле "Имя подписи" не появится
            WebElement NameSignatureField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='xx nr']")));
            //Вводим  данные для поля "Имя подписи"
            NameSignatureField.sendKeys("TEST SIGNATURE");

            // Ожидание, пока кнопка "Создать" не станет кликабельной
            WebElement ButtonCreate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='J-at1-auR']")));
            // Клик по кнопке "Создать"
            ButtonCreate.click();

            // Ожидание, пока поле ввода подписи не появится
            WebElement SignatureBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Am aiL IP Al editable Xp0HJf-LW-avf']")));
            //Вводим  данные для поля подписи
            SignatureBody.sendKeys("SIGNATURE");

            //Ожидание, для ввода подписи
            Thread.sleep(1000);

            // Ожидание, пока выпадающий список не появится
            WebElement ButtonSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='Ps']")));
            // Клик по кнопке c выпадающим списком
            ButtonSelect.click();

            // Ищем выпадающий список
            WebElement DropDown = driver.findElement(By.xpath("//select[@class='Ps']"));
            // Создаем объект  на основе найденного элемента
            Select TestSignature = new Select(DropDown);
            // Выбираем опцию по тексту
            TestSignature.selectByVisibleText("TEST SIGNATURE");

            // Ожидание, пока кнопка "Сохранить изменения" не станет кликабельной
            WebElement SaveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@guidedhelpid='save_changes_button']")));
            // Клик по кнопке "Сохранить изменения"
            SaveButton.click();

            //Ожидание, для сохранения изменений
            Thread.sleep(1000);

            // Ожидание, пока элемент "Написать" не появится
            WebElement WriteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='T-I T-I-KE L3']")));
            // Кликаем на элемент
            WriteButton.click();

            // Ожидание, пока появится поле ввода адреса получателя
            WebElement toField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@class='agP aFw']")));
            // вводим адрес почты получателя в поле "Кому?"
            toField.sendKeys("dmitriy.yegorov.02@gmail.com"); //input[@class='aoT']

            // Ожидание, пока появится поле "Тема"
            WebElement SubjectField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='aoT']")));
            // вводим адрес почты получателя в поле "Тема"
            SubjectField.sendKeys("test");

            // Ожидание, пока кнопка "Отправить" не станет кликабельной
            WebElement SendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")));
            // Клик по кнопке "Отправить"
            SendButton.click();

            // Вывод сообщения об успешной/неуспешной отправки письма с подписью
            System.out.println("письмо с подписью было успешно отправлено!");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            try { //Ожидание закрытие браузера
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}


