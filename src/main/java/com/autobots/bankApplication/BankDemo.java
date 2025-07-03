package com.autobots.bankApplication;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        Mbank eldMbank = new Mbank(123456789012L, 123456789);

        System.out.println(eldMbank.getBalance());
        eldMbank.deposit(200000);
        System.out.println(eldMbank.getBalance());

        OptimaBank eldOptima = new OptimaBank(223456789012L, 223456789);
        System.out.println(eldOptima.getBalance());

        Bank.transferFunds(eldMbank, eldOptima, 100000);
        System.out.println(eldMbank.getBalance());
        System.out.println("Balance: " + eldOptima.getBalance());

        BankBase.all_Bank_Records.stream().filter(s->s.getBalance() > 100).forEach(System.out::println);

        double allSum = BankBase.all_Bank_Records.stream().mapToDouble(Bank::getBalance).sum();
        System.out.println("Sum: " + allSum);
    }
}