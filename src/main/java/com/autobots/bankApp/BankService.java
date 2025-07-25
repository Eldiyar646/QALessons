package com.autobots.bankApp;

public class BankService {

    public static boolean transfer (BankAccount from, BankAccount to, double amount) {
        if (from.withdraw(amount)) {
            double convertedSum = ExchangeRate.convert(amount,from.getCurrency(), to.getCurrency());
            to.deposit(convertedSum);
            from.addTransaction("TRANSFER_OUT", amount);
            from.addTransaction("TRANSFER_IN", convertedSum);
            return true;
        }
        return false;
    }
}
