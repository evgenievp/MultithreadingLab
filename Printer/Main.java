package com.Printer;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        PoemFileReader reader = new PoemFileReader("Printer/input.txt");
        List<String> lines = reader.read();

        SynchronizedPrinter printer = new SynchronizedPrinter(lines);

        Runnable printTask = () -> {
            while (printer.printNextLine()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(printTask, "Printer-" + i);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Main thread interrupted", e);
            }
        }
    }
}