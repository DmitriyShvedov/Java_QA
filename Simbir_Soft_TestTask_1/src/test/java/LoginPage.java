import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private String usernameField;
    private String passwordField;
    WebElement UsernameField;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsernameField(String username) {
        driver.findElement(By.xpath("//span/input")).sendKeys(username);
    }

    public void setPasswordField(String password) {
        driver.findElement(By.xpath("//input[@id='passp-field-passwd']")).sendKeys(password);
    }
}
