import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBaseFunc {

    public static WebElement findElementName(WebDriver driver, int sec, String nameValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue)));
    }

    public static WebElement findElementXpath(WebDriver driver, int sec, String xpathValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
    }

    public static WebElement findElementLinkText(WebDriver driver, int sec, String linkTextValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkTextValue)));
    }

    public static WebElement findElementCss(WebDriver driver, int sec, String CssValue){
        return new WebDriverWait(driver, Duration.ofSeconds(sec))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CssValue)));
    }

}
