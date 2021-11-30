package ru.shvedov;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBaseConfig {

    public static WebDriver driver;
    private String urlSite = "https://www.russianfood.com/";

    @BeforeMethod
    public void lounchbrowser (){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlSite);
        loginIn("Гостевой Альфред", "121212");
    }

    @Test
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


    public void loginIn(String login ,String pass){
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[1]/table/tbody/tr[1]/td/div/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[1]/span[2]/span/i/i")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[1]/input")).sendKeys(login);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[2]/input")).sendKeys(pass);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/input")).click();
        String atr = driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/table/tbody/tr[1]/td/p[2]/a")).getAttribute("innerHTML");
        if (atr == "мои настройки"){
            System.out.println("все хорошо");
        }else screenshot("Erorr on Login");
    }

    RecipeData test = new RecipeData("очень вкусно", "главное полезно","Картошка");

    @Test
    public void addReciept(){
        clickOnAddReciept();
        initNewReciept("7", "1000", "50", "55", test);
        screenshot("compite");
        //submitNewReciept();

    }

    private void submitNewReciept() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/div[8]/input"));
    }

    private void initNewReciept(String numberServings, String numberClalories, String cookingDuration, String myCookingDuration, RecipeData recipeData) {
        selectNameValue("theme_id", "7");
        //Name
        driver.findElement(By.xpath("//*[@id=\"recipe_title\"]")).sendKeys("Холостяцкий борщец");
        //Photo complete bludo
        driver.findElement(By.xpath("//*[@id=\"mainImageUpload\"]")).sendKeys("/Users/dm.shvedov/Desktop/test.png");
        //Kratkoe opisanie
        driver.findElement(By.xpath("//*[@id=\"recipe_announce\"]")).sendKeys(recipeData.getShotDiscription());
        //Tekstovoe opisanie
        driver.findElement(By.id("main_text")).sendKeys(recipeData.getFullDiscription());
        //Photo steps
        driver.findElement(By.id("stepImageUpload")).sendKeys("/Users/dm.shvedov/Desktop/test.png");
        //Ingridienti
        driver.findElement(By.xpath("//*[@id=\"ingrid_text\"]")).sendKeys(recipeData.getIngridients());
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
        //prochee = uzin
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[17]/div/ul")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[17]/div/div/ul/li[12]")).click();
        //bluda = gribi soloenie
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[18]/div/ul")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/p[18]/div/div/ul/li[63]")).click();
        //count porciy = 7
        driver.findElement(By.xpath("//*[@id=\"quantity_of_persons\"]")).sendKeys(numberServings);
        //calloris= 1000
        driver.findElement(By.xpath("//*[@id=\"caloric\"]")).sendKeys(numberClalories);
        //ready time
        driver.findElement(By.xpath("//*[@id=\"ready_time\"]")).sendKeys(cookingDuration);
        //time potratil
        driver.findElement(By.xpath("//*[@id=\"prep_time\"]")).sendKeys(myCookingDuration);
    }

    private void clickOnAddReciept() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[3]/div/table/tbody/tr/td/div[2]/a")).click();
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

    private void screenshot(String name) {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File ("Screenshots/" + name + ".png"));
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
