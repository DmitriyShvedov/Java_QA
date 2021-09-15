package shvedov.qa.vk;

public class TestSeleniumClass extends ConfigWebDriver {

    public static void main(String[] args) throws InterruptedException {

        AuthorizationVK p1 = new AuthorizationVK("shvedov19957@gmail.com", "x2g-cds-5cY-HmA");
        AuthorizationVK p2 = new AuthorizationVK("shvedov772", "tfbwl3ehwankdfsil");
        MessageVkTo m1 = new MessageVkTo("Алиме Дудак", "Жирно тебе будет)");
        MessageVkTo m2 = new MessageVkTo("Нигматзянов Дмитрий", "Привет, я программа, если хочешь, гоу общаться!");

        lounchbrowser("https://vk.com");
        p1.authVk();
        waitSecond(10);
        m1.sendMessTo();
        //m2.sendMessTo();
        closeBrowser();

    }
};


