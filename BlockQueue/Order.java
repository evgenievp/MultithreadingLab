package com.BlockQueue;

public record Order(String type, int quantity) {
    public String toString() {
        return type + " " + quantity;
    }
}
