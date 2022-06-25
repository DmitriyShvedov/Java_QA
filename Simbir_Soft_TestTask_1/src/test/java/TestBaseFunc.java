import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBaseFunc {

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


    @BeforeMethod
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

    @AfterTest
    protected static void closeBrowser(){
        driver.quit();
    }

}
