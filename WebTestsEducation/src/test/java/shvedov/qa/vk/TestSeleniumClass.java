package shvedov.qa.vk;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSeleniumClass extends ConfigWebDriver {
    public static void main(String[] args) throws InterruptedException {

        Authorization p1 = new Authorization("shvedov19957@gmail.com", "x2g-cds-5cY-HmA");
        lounchBrouser("https://vk.com");
        p1.auth(p1);

    }
};


