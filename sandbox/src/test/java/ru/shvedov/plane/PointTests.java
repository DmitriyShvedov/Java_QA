package ru.shvedov.plane;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    
    @Test
    public void testDistance(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(2,1);
        Assert.assertEquals(p2.distance(p1), 1.4142135623731);
    }
}
