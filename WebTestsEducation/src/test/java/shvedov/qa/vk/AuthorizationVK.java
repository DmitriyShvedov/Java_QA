package shvedov.qa.vk;

import org.openqa.selenium.By;

public class AuthorizationVK extends TestBaseConfig {
    private String passAuth;
    private String loginAuth;

    public AuthorizationVK(String login, String pass){
        this.loginAuth = login;
        this.passAuth = pass;
    }

    public String getLoginAuth() {
        return loginAuth;
    }
    public String getPassAuth(){
        return passAuth;
    }

    public void authVk(){
        driver.findElement(By.xpath("//*[@id=\"index_email\"]")).sendKeys(getLoginAuth());
        driver.findElement(By.xpath("//*[@id=\"index_pass\"]")).sendKeys(getPassAuth());
        driver.findElement(By.xpath("//*[@id=\"index_login_button\"]")).click();
    }


}
