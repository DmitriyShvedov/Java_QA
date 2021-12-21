package ru.shvedov.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateHelper {

    private WebDriver driver;

    public NavigateHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMainSite() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[1]/table/tbody/tr[1]/td/div/a/img")).click();
    }

    public void clickOnAddRecipe() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[1]/tbody/tr/td[3]/div/table/tbody/tr/td/div[2]/a")).click();
    }

    public void submitNewRecipe() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/form/div/div[8]/input"));
    }
}
