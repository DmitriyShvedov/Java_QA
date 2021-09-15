package shvedov.qa.vk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class ConfigWebDriver {

    public static WebDriver driver;

    @BeforeMethod
    protected static void lounchbrowser (String urlSite){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.get(urlSite);

    }

    protected static void waitSecond(int time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    protected static void closeBrowser(){
        driver.quit();
    }



}
