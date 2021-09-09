package ru.shvedov.figure;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SquareTests {

    @Test
    public void testArea(){
        Square s1 = new Square(6);
        Assert.assertEquals(s1.area(), 36);
    }

}
