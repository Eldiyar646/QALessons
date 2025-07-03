package com.autobots.bankApplication;

public class Return {
    public static void main(String[] args) {

        System.out.println(sum2(25,5));

        String intToString = Integer.toString(sum2(25,5));
        System.out.println(intToString);



    }

    public static int sum2(int a, int b){
        return a+b;

    }
}
