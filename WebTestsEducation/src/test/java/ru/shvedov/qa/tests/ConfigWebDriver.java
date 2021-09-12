package ru.shvedov.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigWebDriver {

    public static WebDriver driver;

    public static void lounchBrouser (String urlSite){
        System.setProperty("webdriver.chrome.driver","/Users/dm.shvedov/Documents/GitHub/Driver and Jars/chromedriver");
        driver = new ChromeDriver();
        driver.get(urlSite);
    }
}
