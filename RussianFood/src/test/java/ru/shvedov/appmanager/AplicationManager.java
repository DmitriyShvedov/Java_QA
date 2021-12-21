package ru.shvedov.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.shvedov.model.Authorization;
import ru.shvedov.model.RecipeData;

public class AplicationManager {

    WebDriver driver;


    private  NavigateHelper navigateHelper;
    private SubsVoid subsVoid;

    public Authorization authLogin = new Authorization("Гостевой Альфред", "121212");
    private String urlSite = "https://www.russianfood.com/";

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        subsVoid = new SubsVoid(driver);
        navigateHelper = new NavigateHelper(driver);
        driver.get(urlSite);
    }

    public void stop() {
        driver.quit();
    }

    public void loginIn(Authorization loginIN){
        navigateHelper.clickOnMainSite();
        subsVoid.screenshot("step 1");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[1]/span[2]/span/i/i")).click();
        subsVoid.screenshot("step 2");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[1]/input")).sendKeys(loginIN.getLogin());
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/div/p[2]/input")).sendKeys(loginIN.getPassword());
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[2]/form/input")).click();
    }

    public void registration(){
        navigateHelper.clickOnMainSite();
        subsVoid.waitSecond(3);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[1]/noindex/div[1]/div[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[1]")).sendKeys("clarki");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[2]")).sendKeys("shvedov19957@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[3]")).sendKeys("123456789");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/form/input[4]")).sendKeys("123456789");
        subsVoid.selectNameValue("reggender","male");
        subsVoid.selectNameValue("regage","3");
        driver.findElement(By.name("regsubscribe")).click();
        //driver.findElement(By.className("recaptcha-checkbox-border")).click(); капча
        subsVoid.waitSecond(5);
    }

    public SubsVoid getSubsVoid() {
        return subsVoid;
    }
    public void choiceParamsRecipe(String numberServings, String numberClalories, String cookingDuration, String myCookingDuration, RecipeData recipeData) {
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

    public NavigateHelper getNavigateHelper() {
        return navigateHelper;
    }
}
