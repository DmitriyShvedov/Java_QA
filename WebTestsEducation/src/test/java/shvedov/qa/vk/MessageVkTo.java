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

        driver.findElement(By.xpath("/html/body/div[12]/div/div/div[2]/div[1]/div/nav/ol/li[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"s_search\"]")).sendKeys(getName());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[12]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div[2]/div[4]/div[1]/div/div/div[3]/div[4]/a\n")).click();
        driver.findElement(By.xpath("//*[@id=\"mail_box_editable\"]")).sendKeys(getMessage());
        driver.findElement(By.xpath("//*[@id=\"mail_box_send\"]\n")).click();

    }
}
