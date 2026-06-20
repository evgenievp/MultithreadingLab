package com.BlockQueue;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QueueApp {

    public static void main(String[] args) {
        StorageClass storage = new StorageClass(10);
        List<String> orderTypes = List.of("Shoes", "Toys", "Bikes", "Books");

        Thread producer = new Thread(() -> {
            int produceAmount = ThreadLocalRandom.current().nextInt(10, 30);

            for (int i = 0; i < produceAmount; i++) {
                String type = orderTypes.get(
                        ThreadLocalRandom.current().nextInt(orderTypes.size())
                );

                int qty = ThreadLocalRandom.current().nextInt(1, 10);

                Order order = new Order(type, qty);
                storage.addEl(order);
            }
        });

        Runnable consumerTask = () -> {
            int consumeAmount = ThreadLocalRandom.current().nextInt(3, 6);

            for (int i = 0; i < consumeAmount; i++) {
                Order order = storage.consumeEl();

                if (order == null) {
                    continue;
                }

                int consumeQty = ThreadLocalRandom.current().nextInt(1, 30);

                if (order.getQuantity() > consumeQty) {
                    int remaining = order.getQuantity() - consumeQty;

                    System.out.println(
                            "Consumed " + consumeQty + " from " + order.getType()
                                    + ". Remaining: " + remaining
                    );

                    storage.addEl(new Order(order.getType(), remaining));
                } else {
                    System.out.println("Consumed whole order: " + order);
                }
            }
        };

        Thread consumer1 = new Thread(consumerTask);
        Thread consumer2 = new Thread(consumerTask);
        Thread consumer3 = new Thread(consumerTask);

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
            consumer3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        System.out.println("Final storage size: " + storage.size());
    }
}