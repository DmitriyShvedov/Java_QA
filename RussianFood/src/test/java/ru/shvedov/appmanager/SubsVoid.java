package ru.shvedov.appmanager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SubsVoid {

    private WebDriver dr;
    public SubsVoid(WebDriver driver) {
        this.dr = driver;
    }

    public void selectNameValue(String name, String reg){
        WebElement dropdown = dr.findElement(By.name(name));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue(reg);
    }

    public void selectClassValue(String clas, String reg){
        WebElement dropdown = dr.findElement(By.className(clas));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue(reg);
    }

    public WebElement waitObjXpath(String obj){
        WebElement e = (new WebDriverWait(dr, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj))));
        return e;
    }

    public WebElement findByElementXpath(String obj){
        WebElement e = dr.findElement(By.xpath(obj));
        return e;
    }

    public void screenshot(String name) {
        File screenshotFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File ("Screenshots/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitSecond(int time){
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
