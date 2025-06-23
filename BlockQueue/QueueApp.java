package com.BlockQueue;

import java.util.List;
import java.util.Random;

public class QueueApp {
    public static void main(String[] args) {
        Random random = new Random();
        StorageClass storage = new StorageClass();
        List<String> orderTypes = List.of(new String[]{"Shoes", "Toys", "Bikes", "Books"});
        Thread producer = new Thread(() -> {
           int qty = random.nextInt(1, 6);
           int produceAmount = random.nextInt(10, 30);
            for (int i = 0; i < produceAmount; i++) {
                Order currentOrder = new Order(orderTypes.get(random.nextInt(0, 4)), qty);
                storage.addEl(currentOrder);
            }
        });

        Thread consumer1 = new Thread(()-> {
           int consumeAmount = random.nextInt(3, 6);
            for (int i = 0; i < consumeAmount; i++) {
                storage.consumeEl();
            }
        });

        Thread consumer2 = new Thread(()-> {
            int consumeAmount = random.nextInt(1, 4);
            for (int i = 0; i < consumeAmount; i++) {
                storage.consumeEl();
            }
        });

        Thread consumer3 = new Thread(()-> {
            int consumeAmount = random.nextInt(2, 6);
            for (int i = 0; i < consumeAmount; i++) {
                storage.consumeEl();
            }
        });

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
            throw new RuntimeException(e);
        }

    }
}
