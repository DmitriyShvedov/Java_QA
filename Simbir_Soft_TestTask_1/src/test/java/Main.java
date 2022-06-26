import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Objects;

public class Main extends TestBaseFunc {

    final static String nameFile = "Файл для копирования.pages";
    final static String urlSute = "https://yandex.ru/";
    final static String userName = "dmShvedov7";
    final static String password = "ditdok-xypDuz-0jabfa";

    public static void main(String[] args) throws InterruptedException {

        lounchbrowser(urlSute);

        //нажимаю кнопку войти
        driver.findElement(By.xpath("//a/div[2]")).click();

        LoginPage loginPage = new LoginPage(driver);

        Thread.sleep(1000);

        loginPage.setUsernameField(userName);

        driver.findElement(By.xpath("//div[4]/button")).click();

        passwordField = findElementName(driver, 10, "passwd");
        passwordField.sendKeys(password);

        //подтверждаю пароль
        driver.findElement(By.xpath("//*[@id=\"passp:sign-in\"]")).click();

        //перехожу в диск
        linkDisk = findElementLinkText(driver, 10, "Диск");
        linkDisk.click();

        //переключаю вкладки между собой
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //ищу кнопку создать
        buttmCreate = findElementXpath(driver, 10, "//div[@id='app']/div/div/div[3]/div/div/div/div/span[2]/button");
        buttmCreate.click();


        //нажимаю кнопку папка
        buttmFolder = findElementCss(driver, 10, ".file-icon_dir_plus");
        buttmFolder.click();


        //нахожу поле где нужно ввести название папки
        folderNameField = findElementXpath(driver, 10, "/html/body/div[3]/div[2]/div/div/div/div/div/div[1]/div/form/span/input");
        Thread.sleep(1000);

        folderNameField.sendKeys(Keys.DELETE);

        String nameFolder = "Тестовая папка";
        folderNameField.sendKeys(nameFolder);


        //Сохраняем новую папку
        buttmSave = findElementXpath(driver, 10, "(//button[@type='button'])[6]");
        buttmSave.click();

        //жму на крестик
        buttmCancel = findElementXpath(driver, 10, "//button[@aria-label='Отменить выделение']");
        buttmCancel.click();

        //Ищу файл который надо скопировать
        fileNameSearch = findElementXpath(driver, 10, "//div[@aria-label='Файл для копирования.pages']");
        fileNameSearch.click();

        //нажимаю копировать
        buttmCopy = findElementXpath(driver, 10, "//button[@aria-label='Копировать']");
        buttmCopy.click();

        //в модальном окне выбираю созданную папку
        fileChoice = findElementXpath(driver, 10, "//div[@title='Тестовая папка']");
        fileChoice.click();

        //подтверждаю выбор папки
        buttmConfirm = findElementXpath(driver, 10, "/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/button[2]");
        buttmConfirm.click();


        //закрываю крестик
        buttmCancel = findElementXpath(driver, 10, "//button[@aria-label='Отменить выделение']");

        buttmCancel.click();

        //нахожу папку
        searchFolder = findElementXpath(driver, 10, "//div[@aria-label='Тестовая папка']");
        searchFolder.click();


        //пытаюсь два раза нажать
        Actions act = new Actions(driver);
        act.doubleClick(searchFolder).perform();

        checkNameFolder = findElementXpath(driver, 10, "//h1[@title='Тестовая папка']");
        String tempNameFolder = checkNameFolder.getAttribute("title");

        if (Objects.equals(tempNameFolder, nameFolder)) {
            System.out.println("Название папки соответвует введенному названию в начале теста");
        } else
            System.out.println("Название папки не соответвует введенному названию в начале теста");

        //Thread.sleep(100000);
        checkNameFile = findElementXpath(driver, 20, "//div[@aria-label='Файл для копирования.pages']");
        String tempNameFile = checkNameFile.getAttribute("ariaLabel");

        if (Objects.equals(tempNameFile, nameFile)) {
            System.out.println("Название файла соответвует введенному названию в начале теста");
        } else
            System.out.println("Название файла не соответвует введенному названию в начале теста");

        //иконка профиля
        buttmProfile = findElementXpath(driver, 20, "/html/body/div[1]/div/div/div[1]/div[3]/div/div/a[1]/div/img");
        buttmProfile.click();

        //выйти из профиля
        quitOfProfile = findElementXpath(driver, 20, "//a[@aria-label='Выйти из аккаунта']");
        quitOfProfile.click();

        closeBrowser();

    }

}
