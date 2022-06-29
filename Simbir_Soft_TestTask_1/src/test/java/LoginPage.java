import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsernameField(String username) {
        driver.findElement(By.xpath("//span/input")).sendKeys(username);
    }

}
