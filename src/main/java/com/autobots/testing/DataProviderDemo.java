package com.autobots.testing;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"admin", "validPassword"},
                {"invalidUsername", "invalidPAssword"},
                {"validUsername", "invalidPAssword"},
                {"invalidUsername", "validPAssword"},
        };
    }

    @Test(dataProvider = "loginData")
    void loginWithValidUsernameAndPassword(String username, String password){
        System.out.println("Testing the login with: " + username + " and password: " + password);
    }
}