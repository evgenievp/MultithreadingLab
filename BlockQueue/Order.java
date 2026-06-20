package com.BlockQueue;


public class Order {
    private final String type;
    private final int quantity;

    public Order(String type, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return type + " (" + quantity + ")";
    }
}