import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
         WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "/Users/dm.shvedov/Desktop/QA/Auto QA/jars and driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://yandex.ru/");

        driver.findElement(By.xpath("//a/div[2]")).click();
        driver.findElement(By.xpath("//span/input")).click();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsernameField("dmShvedov7");
        driver.findElement(By.xpath("//div[4]/button")).click();

        WebElement e = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("passwd"))));
        e.click();
        e.sendKeys("ditdok-xypDuz-0jabfa");

        driver.findElement(By.xpath("//*[@id=\"passp:sign-in\"]")).click();

        WebElement b = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Диск"))));
        b.click();

        //переключаю вкладки между собой
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        //ищу кнопку создать
        WebElement c = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app']/div/div/div[3]/div/div/div/div/span[2]/button"))));
        c.click();


        //нажимаю кнопку файл
        WebElement q = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".file-icon_dir_plus"))));
        q.click();


        //нахожу поле где нужно ввести название папки
        WebElement w = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div[1]/div/form/span/input"))));

        /*
        w.sendKeys(Keys.DELETE);
        w.sendKeys("Тестовая папка");
         */

        //Сохраняем новую папку
        WebElement r = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[6]"))));
        r.click();

        //жму на крестик
        WebElement y = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "(//button[@type='button'])[9]")))));
        y.click();

        //Ищу файл который надо скопировать
        WebElement t = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "//div[@aria-label='Файл для копирования.pages']")))));
                        // "//div[@id='app']/div/div/div[3]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div")))));
        System.out.println("Нашел");
        t.click();

        //нажимаю копировать
        WebElement u = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "(//button[@type='button'])[7]")))));
        u.click();

        //в модальном окне выбираю созданную папку
        WebElement i = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "//div[@title='Новая папка']")))));
        i.click();

        //подтверждаю выбор папки
        WebElement o = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/button[2]")))));
        o.click();


        //закрываю крестик
        y = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "(//button[@type='button'])[9]")))));

        y.click();

        //нахожу папку
        WebElement p = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "//div[@aria-label='Новая папка']")))));
        p.click();


        //пытаюсь два раза нажать
        Actions act = new Actions(driver);
        act.doubleClick(p).perform();


        WebElement n = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "//h1[@title='Новая папка']")))));
        System.out.println("Нашел название папки");

        //Thread.sleep(100000);
        WebElement m = (new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "//div[@aria-label='Файл для копирования.pages']")))));
        System.out.println("Нашел файл");


        //иконка профиля
        WebElement h = (new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "/html/body/div[1]/div/div/div[1]/div[3]/div/div/a[1]/div/img")))));
        h.click();

        //выйти из профиля
        WebElement g = (new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("" +
                        "//a[@aria-label='Выйти из аккаунта']")))));
        g.click();

        driver.quit();

    }
}
