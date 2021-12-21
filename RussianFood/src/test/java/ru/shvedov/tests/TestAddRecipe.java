package ru.shvedov.tests;

import org.testng.annotations.Test;
import ru.shvedov.model.RecipeData;

public class TestAddRecipe extends TestBase {


    RecipeData test = new RecipeData("очень вкусно", "главное полезно","Картошка");

    @Test
    public void addRecipe(){
        app.loginIn(app.authLogin);
        app.getNavigateHelper().clickOnAddRecipe();
        initNewRecipe("7", "1000", "50", "55", test);
        app.getSubsVoid().screenshot("TestAddRecipe");
        //submitNewReciept();

    }

    private void initNewRecipe(String numberServings, String numberClalories, String cookingDuration, String myCookingDuration, RecipeData recipeData) {
        app.getSubsVoid().selectNameValue("theme_id", "7");
        app.choiceParamsRecipe(numberServings, numberClalories, cookingDuration, myCookingDuration, recipeData);
    }


}
