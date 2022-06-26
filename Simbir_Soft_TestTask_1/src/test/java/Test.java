import java.io.IOException;

public class Test extends TestBaseFunc {

    @org.testng.annotations.Test
    public void test() throws InterruptedException, IOException {
        lounchbrowser(urlSute);
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
