package ru.shvedov;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class AddRecipe extends TestBase {


    RecipeData test = new RecipeData("очень вкусно", "главное полезно","Картошка");

    @Test
    public void addRecipe(){
        loginIn(authLogin);
        clickOnAddRecipe();
        initNewRecipe("7", "1000", "50", "55", test);
        screenshot("compite");
        //submitNewReciept();

    }

    private void initNewRecipe(String numberServings, String numberClalories, String cookingDuration, String myCookingDuration, RecipeData recipeData) {
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

    private void clickOnAddRecipe() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[3]/div/table/tbody/tr/td/div[2]/a")).click();
    }


}
