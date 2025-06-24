BlockingQueue – Producer-Consumer Demo
This project demonstrates a basic use case of BlockingQueue, which is an inherently asynchronous data structure.

What it demonstrates
Multiple threads (producers and consumers) working concurrently

Thread-safe queue operations without explicit locking

Handling edge cases like:

Preventing consumers from reading when the queue is empty

Preventing producers from overfilling the queue

How it works
A Storage class wraps a fixed-size ArrayBlockingQueue (capacity 10)

A producer thread adds orders to the queue

Multiple consumer threads remove orders from it concurrently

This simple simulation shows how BlockingQueue helps synchronize producer-consumer workflows without additional synchronization logic.