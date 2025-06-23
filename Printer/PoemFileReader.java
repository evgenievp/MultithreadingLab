package com.Printer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PoemFileReader {
    private String path;
    private List<String> text;

    public PoemFileReader(String path) {
        this.path = path;
        this.text = new ArrayList<>();
    }

    public List<String> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.add(line);
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
