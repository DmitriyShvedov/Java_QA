package ru.shvedov.tests;

import org.testng.annotations.Test;
import ru.shvedov.model.Authorization;

public class TestAuthorization extends TestBase {

    Authorization testLoginWrong = new Authorization("бла бла бла", "пум пум пум");

    @Test
    public void testLoginIN(){
        app.loginIn(testLoginWrong);
        app.getSubsVoid().screenshot("testLoginWrong");
    }
}
