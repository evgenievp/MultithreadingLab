package com.Printer;

import java.util.List;

public class SynchronizedPrinter {
    private final List<String> text;
    private int currentLine = 0;

    public SynchronizedPrinter(List<String> text) {
        this.text = text;
    }

    public synchronized boolean printNextLine() {
        if (currentLine >= text.size()) {
            return false;
        }

        System.out.println(
                Thread.currentThread().getName() + ": " + text.get(currentLine)
        );

        currentLine++;
        return true;
    }
}