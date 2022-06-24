import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private String usernameField;
    private String passwordField;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
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
