package ru.shvedov.qa.tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSeleniumClass extends ConfigWebDriver {

    public static void main(String[] args) throws InterruptedException {

        Authorization shvedovDima = new Authorization("shvedov19957@gmail.com", "x2g-cds-5cY-HmA");

        lounchBrouser("https://vk.com");

        driver.findElement(By.xpath("//*[@id=\"index_email\"]")).sendKeys(shvedovDima.getLoginAuth());

        driver.findElement(By.xpath("//*[@id=\"index_pass\"]")).sendKeys(shvedovDima.getPassAuth());

        driver.findElement(By.xpath("//*[@id=\"index_login_button\"]")).click();

        driver.wait(10000);
        driver.close();
    }
};


