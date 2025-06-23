package com.Printer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PoemFileReader reader = new PoemFileReader("src/input.txt");
        List<String> result = new ArrayList<>();
        result = reader.read();

        Printer printer = new Printer(result);

        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    boolean printed = printer.print();
                    if (!printed) break;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    boolean printed = printer.print();
                    if (!printed) break;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable thread3 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    boolean printed = printer.print();
                    if (!printed) break;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable thread4 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    boolean printed = printer.print();
                    if (!printed) break;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable thread5 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    boolean printed = printer.print();
                    if (!printed) break;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };


        Thread th1 = new Thread(thread1);
        Thread th2 = new Thread(thread2);
        Thread th3 = new Thread(thread3);
        Thread th4 = new Thread(thread4);
        Thread th5 = new Thread(thread5);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();

        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
            th5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}