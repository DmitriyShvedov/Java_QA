package ru.shvedov.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import ru.shvedov.appmanager.AplicationManager;
import ru.shvedov.model.RecipeData;

public class TestBase {

    protected final AplicationManager app = new AplicationManager();

    @BeforeMethod
    public void lounchBrowser (){
        app.setUp();
    }

    @AfterTest
    protected void closeBrowser(){
        app.stop();
    }



}
