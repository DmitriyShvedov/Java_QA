package shvedov.qa.vk;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TestSeleniumClass extends ConfigWebDriver {

    public static void main(String[] args) throws InterruptedException {

        Authorization p1 = new Authorization("shvedov19957@gmail.com", "x2g-cds-5cY-HmA");
        Authorization p2 = new Authorization("shvedov772", "tfbwl3ehwankdfsil");
        MessageVkTo m1 = new MessageVkTo("Алиме Дудак", "Я тебя люблю");
        lounchBrouser("https://vk.com");
        p1.authVk();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        m1.sendMessTo();
        driver.quit();
    }
};


