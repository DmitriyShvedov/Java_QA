import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

public class TestBaseFunc extends Locators {

    final static String nameFile = "Файл для копирования.pages";
    final static String urlSute = "https://yandex.ru/";
    final static String userName = "dmShvedov7";
    final static String password = "ditdok-xypDuz-0jabfa";
    public static WebElement passwordField;
    public static WebElement linkDisk;
    public static WebElement buttmCreate;
    public static WebElement buttmFolder;
    public static WebElement folderNameField;
    public static WebElement buttmSave;
    public static WebElement buttmCancel;
    public static WebElement fileNameSearch;
    public static WebElement buttmCopy;
    public static WebElement fileChoice;
    public static WebElement buttmConfirm;
    public static WebElement searchFolder;
    public static WebElement checkNameFolder;
    public static WebElement checkNameFile;
    public static WebElement buttmProfile;
    public static WebElement quitOfProfile;
    public static WebDriver driver;
    public static String nameFolder = "Тестовая папка";

    protected static void lounchbrowser (String urlSite){
        System.setProperty("webdriver.chrome.driver", "/Users/dm.shvedov/Desktop/QA/Auto QA/jars and driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(urlSite);

    }

    public static WebElement findElementName(WebDriver driver, int sec, String nameValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue)));
    }

    public static WebElement findElementXpath(WebDriver driver, int sec, String xpathValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
    }

    public static WebElement findElementLinkText(WebDriver driver, int sec, String linkTextValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkTextValue)));
    }

    public static WebElement findElementCss(WebDriver driver, int sec, String CssValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CssValue)));
    }

    void clickOkCookey(){
        findElementXpath(driver,10,locCookiOk);
    }

    public static void signIn(){
        driver.findElement(By.xpath(locSigIn)).click();
    }

    public static void confirmUserName(){
        driver.findElement(By.xpath(locConfirmUserName)).click();
    }

    public static void confirmPass(){
        driver.findElement(By.xpath(locConfirmUserName)).click();
    }

    protected static void closeBrowser(){
        driver.quit();
    }

    public void sendPassword() {
        passwordField = findElementName(driver, 10, locPassword);
        passwordField.sendKeys(password);
    }

    void outProfile() {
        //иконка профиля
        buttmProfile = findElementXpath(driver, 20, locProfileIcon);
        buttmProfile.click();

        //выйти из профиля
        quitOfProfile = findElementXpath(driver, 20, locOutOfProfile);
        quitOfProfile.click();
    }

    void checkNameFile() throws IOException {
        checkNameFile = findElementXpath(driver, 20, locNameFile);
        String tempNameFile = checkNameFile.getAttribute(locFindAtribAriaLabel);

        if (Objects.equals(tempNameFile, nameFile)) {
            System.out.println("Название файла соответвует введенному названию в начале теста");
        } else
            throw new IOException();
    }

    void checkNameFolder() throws IOException {
        checkNameFolder = findElementXpath(driver, 10, locNameFolder);
        String tempNameFolder = checkNameFolder.getAttribute(locFindAtribTitle);

        if (Objects.equals(tempNameFolder, nameFolder)) {
            System.out.println("Название папки соответвует введенному названию в начале теста");
        } else
            throw new IOException();
    }

    void insideFolder() {
        //нахожу папку
        searchFolder = findElementXpath(driver, 10, locSearchNameFolder);
        searchFolder.click();
        //пытаюсь два раза нажать
        Actions act = new Actions(driver);
        act.doubleClick(searchFolder).perform();
    }

    void copyFileOnFolder() {
        //Ищу файл который надо скопировать
        fileNameSearch = findElementXpath(driver, 10, locNameFile);
        fileNameSearch.click();
        //нажимаю копировать
        buttmCopy = findElementXpath(driver, 10, locButtmCopy);
        buttmCopy.click();
        //в модальном окне выбираю созданную папку
        fileChoice = findElementXpath(driver, 10, locChoiceFolder);
        fileChoice.click();
        //подтверждаю выбор папки
        buttmConfirm = findElementXpath(driver, 10, locConfirmChoiceFolder);
        buttmConfirm.click();
    }

    void clickCancel() {
        buttmCancel = findElementXpath(driver, 10, locClickCancel);
        buttmCancel.click();
    }

    void createFolder() throws InterruptedException {
        folderNameField = findElementXpath(driver, 10, locFolderNameField);
        Thread.sleep(1000);
        folderNameField.sendKeys(Keys.DELETE);
        folderNameField.sendKeys(nameFolder);
        buttmSave = findElementXpath(driver, 10, locButtmSave);
        buttmSave.click();
    }

    void choiceFolder() {
        buttmFolder = findElementCss(driver, 10, locButtmFolder);
        buttmFolder.click();
    }

    void clickCreate() {
        buttmCreate = findElementXpath(driver, 10, locButtmCreateFolder);
        buttmCreate.click();
    }

    void sendUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.setUsernameField(userName);
    }

    void swichWindow() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    void cliclOnDisk() {
        linkDisk = findElementLinkText(driver, 10, locButtmDisk);
        linkDisk.click();
    }

}
