package shvedov.qa.vk;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSeleniumClass extends TestBaseConfig {


    public static void main(String[] args) throws InterruptedException {

        AuthorizationVK p1 = new AuthorizationVK("shvedov19957@gmail.com", "bad_pass");
        AuthorizationVK p2 = new AuthorizationVK("shvedov772", "tfbwl3ehwankdfsil");
        MessageVkTo m1 = new MessageVkTo("Алиме Дудак", "Привет) это прога. ЯТЛ");
        MessageVkTo m2 = new MessageVkTo("Нигматзянов Дмитрий", "Привет, я программа, если хочешь, гоу общаться!");


       // lounchbrowser("https://vk.com");
        /*
        p1.authVk();
        waitSecond(10);
        m1.sendMessTo();
        //m2.sendMessTo();
        */
        lounchbrowser("https://www.avito.ru/");

        WebElement e = findByElementXpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/div[1]/a");
        String arr = e.getAttribute("namespaceURI");
        System.out.println(arr);

        closeBrowser();

    }
};



