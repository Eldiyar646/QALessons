package com.autobots.testing;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforClassDemo extends BeforeSuiteDemo {

    @AfterClass
    public void closeBaseUrl() {
        System.out.println("BeforClassDemo --> After class");
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

    @BeforeClass
    public void openBaseUrl() {
        System.out.println("BeforClassDemo --> Before class");
    }

    @BeforeMethod
    public void openBaseMethod() {
        System.out.println("BeforClassDemo --> Before Method");
    }

    @AfterMethod
    public void CloseBaseMethod() {
        System.out.println("BeforClassDemo --> After Method");
    }
}