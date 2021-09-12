package shvedov.qa.vk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class ConfigWebDriver {

    public static WebDriver driver;

    @BeforeMethod
    public static void lounchBrouser (String urlSite){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.get(urlSite);
    }
}
