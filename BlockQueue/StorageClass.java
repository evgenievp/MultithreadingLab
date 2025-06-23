package com.BlockQueue;

import com.BlockQueue.Order;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class StorageClass {
    BlockingQueue queue;

    public StorageClass() {
        this.queue = new ArrayBlockingQueue<>(10);
    }

    public void consumeEl() {
        if (!queue.isEmpty()) {
            Order first = (Order) queue.peek();
            System.out.println("Order consumed " + first);
            queue.poll();
        }
        else {
            System.out.println("Storage is empty");
        }
    }

    public void addEl(Order el) {
        if (queue.size() < 10) {
            queue.add(el);
            System.out.println("Order %s added to storage " + el);
        }
        else {
            System.out.println("Storage is full! ");
        }
    }

}
