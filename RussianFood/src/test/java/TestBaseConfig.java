
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBaseConfig {

    public static WebDriver driver;
    private String urlSite = "https://www.russianfood.com/";

    @BeforeMethod
    public void lounchbrowser (){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlSite);
    }

    @Test
    public void Registration(){
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


    public void Login(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[1]/table/tbody/tr[1]/td/div/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[1]/span[2]/span/i/i")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[1]/input")).sendKeys("Гостевой Альфред");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[2]/input")).sendKeys("121212");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/input")).click();
        String atr = driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/table/tbody/tr[1]/td/p[2]/a")).getAttribute("innerHTML");
        if (atr == "мои настройки"){
            System.out.println("все хорошо");
        }
    }

    @Test
    public void AddReciept(){
        //Autorization
        Login();
        //tema
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[3]/div/table/tbody/tr/td/div[2]/a")).click();
        selectNameValue("theme_id", "7");
        //Name
        driver.findElement(By.xpath("//*[@id=\"recipe_title\"]")).sendKeys("Холостяцкий борщец");
        //Photo complete bludo
        driver.findElement(By.xpath("//*[@id=\"mainImageUpload\"]")).sendKeys("/Users/dm.shvedov/Desktop/test.png");
        //Kratkoe opisanie
        driver.findElement(By.xpath("//*[@id=\"recipe_announce\"]")).sendKeys("Добавить лучек, потом капустку, значит, и додицей залить это добро");
        //Tekstovoe opisanie
        driver.findElement(By.id("main_text")).sendKeys("Nu tut mnogo texts");
        //Photo steps
        driver.findElement(By.id("stepImageUpload")).sendKeys("/Users/dm.shvedov/Desktop/test.png");
        //Ingridienti
        driver.findElement(By.xpath("//*[@id=\"ingrid_text\"]")).sendKeys("Kartoshechka");
        //tipi bludo otkrit' vibor i vibrat' element
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[12]/div/ul")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[12]/div/div/ul/li[3]")).click();
        //vibrat' esche 1 variant tipi bludo
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[12]/div/ul")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[12]/div/div/ul/li[4]")).click();
        //national kitchen(Arzeibadjan)
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[13]/div/ul/li/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[13]/div/div/ul/li[6]")).click();
        //prazdniki (8 marta)
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[14]/div/ul")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[14]/div/div/ul/li[4]")).click();
        //Tip prigitivleniya (Gril)
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[15]/div/ul/li/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[15]/div/div/ul/li[16]")).click();
        //Vozrast
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[16]/div/ul/li/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[16]/div/div/ul/li[2]")).click();
        Screenshot();
    }

    private void selectNameValue(String name, String reg){
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

    private void Screenshot() {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File ("*/Screenshots/screnshots.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void waitSecond(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    protected void closeBrowser(){
        driver.quit();
    }



}
