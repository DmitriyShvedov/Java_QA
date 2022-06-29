import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Test extends TestBaseFunc {

    @BeforeTest
    public void start(){
        lounchbrowser(urlSute);
    }

    @org.testng.annotations.Test
    public void test() throws InterruptedException, IOException {
        signIn();
        sendUserName();
        confirmUserName();
        sendPassword();
        confirmPass();
        cliclOnDisk();
        swichWindow();
        clickCreate();
        choiceFolder();
        createFolder();
        clickCancel();
        copyFileOnFolder();
        clickCancel();
        insideFolder();
        checkNameFolder();
        checkNameFile();
        outProfile();
        closeBrowser();
    }
}
