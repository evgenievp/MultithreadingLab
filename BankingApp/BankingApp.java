package com.BankingApp;
import java.util.Random;

public class BankingApp {
    public static void main(String[] args) {
        Random random = new Random();
        SharedBankAccount account = new SharedBankAccount(100_000);
        Thread client1 = new Thread(() -> {
            int times = random.nextInt(1, 11);
            for (int i = 0; i < times; i++) {
                int choice = random.nextInt(0, 2);
                double amountEuro = random.nextDouble(30, 10_000);
                if (choice == 1) {
                    account.withdraw(amountEuro);
                } else {
                    account.deposit(amountEuro);
                }
            }
        });
        Thread client2 = new Thread(() -> {
            int times = random.nextInt(1, 11);
            for (int i = 0; i < times; i++) {
                int amountEuro = random.nextInt(10, 20_000);
                int amountCents = random.nextInt(0, 100);
                int choice = random.nextInt(0, 2);
                amountEuro += amountCents / 100;
                if (choice == 1) {
                    account.withdraw(amountEuro);
                } else {
                    account.deposit(amountEuro);
                }
            }
        });
        Thread client3 = new Thread(() -> {
            int times = random.nextInt(1, 11);
            for (int i = 0; i < times; i++) {

                int amountEuro = random.nextInt(10, 20_000);
                int amountCents = random.nextInt(0, 100);
                int choice = random.nextInt(0, 2);
                amountEuro += amountCents / 10;
                if (choice == 1) {
                    account.withdraw(amountEuro);
                } else {
                    account.deposit(amountEuro);
                }
            }
        });


        client1.start();
        client2.start();
        client3.start();

        try {
            client1.join();
            client2.join();
            client3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
