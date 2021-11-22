
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBaseConfig{

    public static WebDriver driver;
    private String urlSite = "https://www.russianfood.com/";

    @BeforeMethod
    public void lounchbrowser (){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.get(urlSite);
        driver.manage().window().maximize();

    }
    @Test
    public void Registration(){
        waitSecond(3);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[1]")).sendKeys("clarki");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[2]")).sendKeys("shvedov19957@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[3]")).sendKeys("123456789");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[4]")).sendKeys("123456789");




    }

    protected void waitObjXpath(String obj){
        WebElement e = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj))));
    }

    protected WebElement findByElementXpath(String obj){
        WebElement e = driver.findElement(By.xpath(obj));
        return e;
    }


    protected void waitSecond(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    protected void closeBrowser(){
        driver.quit();
    }



}
