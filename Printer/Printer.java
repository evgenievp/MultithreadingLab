package com.Printer;

import java.util.List;

public class Printer {
    private final List<String> text;
    private volatile int count = 0;

    public Printer(List<String> message) {
        this.text = message;
    }

    public synchronized boolean print() {
        if (count < text.size()) {
            System.out.println(Thread.currentThread().getName() + ": " + text.get(count));
            count++;
            return true;
        }
        return false;
    }
}
