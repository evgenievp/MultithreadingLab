package com.BlockQueue;



import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StorageClass {
    private final BlockingQueue<Order> queue;

    public StorageClass(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public boolean addEl(Order order) {
        boolean added = queue.offer(order);

        if (added) {
            System.out.println("Order added to storage: " + order);
        } else {
            System.out.println("Storage is full: " + order + " was rejected");
        }

        return added;
    }

    public Order consumeEl() {
        Order order = queue.poll();

        if (order == null) {
            System.out.println("Storage is empty");
            return null;
        }

        System.out.println("Order consumed: " + order);
        return order;
    }

    public Order consumeElWaiting() throws InterruptedException {
        Order order = queue.take();
        System.out.println("Order consumed: " + order);
        return order;
    }

    public int size() {
        return queue.size();
    }
}