package shvedov.qa.vk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBaseConfig {

    public static WebDriver driver;

    @BeforeMethod
    protected static void lounchbrowser (String urlSite){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.get(urlSite);

    }

    protected static void waitObjXpath(String obj){
        WebElement e = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj))));
    }

    protected static void waitSecond(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    protected static void closeBrowser(){
        driver.quit();
    }



}
