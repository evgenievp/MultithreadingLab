package com.Printer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PoemFileReader {
    private final Path path;

    public PoemFileReader(String path) {
        this.path = Path.of(path);
    }

    public List<String> read() {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + path, e);
        }
    }
}