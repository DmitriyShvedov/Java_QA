package shvedov.qa.vk;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class MessageVkTo extends ConfigWebDriver {

    String Name;
    String Message;

    public MessageVkTo(String name, String Message){
        this.Name = name;
        this.Message = Message;
    }

    public String getName(){
        return this.Name;
    }
    public String getMessage(){
        return this.Message;
    }

    public void sendMessTo(){

        driver.findElement(By.xpath("//li[@id='l_fr']/a/span")).click();
        driver.findElement(By.id("s_search")).clear();
        driver.findElement(By.id("s_search")).sendKeys(getName());
        driver.findElement(By.linkText("Написать сообщение")).click();
        driver.findElement(By.id("mail_box_editable")).click();
        driver.findElement(By.id("mail_box_editable")).sendKeys(getMessage());
        driver.findElement(By.id("mail_box_send")).click();
        driver.findElement(By.xpath("//li[@id='l_pr']/a/span")).click();

    }
}
