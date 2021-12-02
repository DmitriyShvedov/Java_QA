package ru.shvedov;

import org.testng.annotations.Test;

public class TestAuthorization extends TestBase {

    Authorization testLoginWrong = new Authorization("бла бла бла", "пум пум пум");

    @Test
    public void testLoginIN(){
        loginIn(testLoginWrong);
        screenshot("testLoginWrong");
    }
}
