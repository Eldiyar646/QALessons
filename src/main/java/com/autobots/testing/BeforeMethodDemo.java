package com.autobots.testing;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeMethodDemo extends BeforeSuiteDemo {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethodDemo --> Before Method");
    }

    @Test
    void test() {
        System.out.println("Ticket to Turkey");
        Assert.assertTrue(true);
    }

    @Test
    void test1() {
        System.out.println("Ticket to Italy");
        Assert.assertTrue(true);
    }

    @Test
    void test2() {
        System.out.println("Ticket to Thailand");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void AfterMethod (){
        System.out.println("BeforeMethodDemo --> After Method");
    }

}
