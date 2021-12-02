package ru.shvedov;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {

    public static WebDriver driver;
    private String urlSite = "https://www.russianfood.com/";

    Authorization authLogin = new Authorization("Гостевой Альфред", "121212");

    @BeforeMethod
    public void lounchbrowser (){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlSite);
    }

    @AfterTest
    protected void closeBrowser(){
        driver.quit();
    }

    public void loginIn(Authorization loginIN){
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[1]/table/tbody/tr[1]/td/div/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[1]/span[2]/span/i/i")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[1]/input")).sendKeys(loginIN.getLogin());
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[2]/input")).sendKeys(loginIN.getPassword());
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/input")).click();
    }





    public void registration(){
        waitSecond(3);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[1]")).sendKeys("clarki");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[2]")).sendKeys("shvedov19957@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[3]")).sendKeys("123456789");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[4]")).sendKeys("123456789");
        selectNameValue("reggender","male");
        selectNameValue("regage","3");
        driver.findElement(By.name("regsubscribe")).click();
        //driver.findElement(By.className("recaptcha-checkbox-border")).click(); капча
        waitSecond(5);
    }



    private void submitNewRecipe() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/div[8]/input"));
    }

    protected void selectNameValue(String name, String reg){
        WebElement dropdown = driver.findElement(By.name(name));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue(reg);
    }

    private void selectClassValue(String clas, String reg){
        WebElement dropdown = driver.findElement(By.className(clas));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue(reg);
    }

    private WebElement waitObjXpath(String obj){
        WebElement e = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj))));
        return e;
    }

    private WebElement findByElementXpath(String obj){
        WebElement e = driver.findElement(By.xpath(obj));
        return e;
    }

    public void screenshot(String name) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File ("Screenshots/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void waitSecond(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


}
