package com.BankingApp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBankAccount {
    private double balance;
    private Lock lock;

    public SharedBankAccount(double initBalance) {
        this.balance = initBalance;
        this.lock = new ReentrantLock();
    }
    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                System.out.printf("Successful deposit operation.Old balance %.2f euro\n", balance);
                this.balance += amount;
                System.out.printf("New balance is: %.2f euro \n", balance);
                System.out.println("-".repeat(30));
            }
            else {
                System.out.printf("Failed to operate with bank account at this time. :( \n");
                System.out.println("-".repeat(30));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    public void withdraw(double amount) {
        try {
            if (lock.tryLock(200, TimeUnit.MILLISECONDS)) {
                if (amount <= this.balance) {
                    this.balance -= amount;
                    System.out.printf("Successful withdraw of %.2f euro. Money left: %.2f euro. \n", amount, balance);
                    System.out.println("-".repeat(30));
                }
                else {
                    System.out.println("Not enough money in the bank account. :(");
                    System.out.println("-".repeat(30));
                }
            }
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

}
