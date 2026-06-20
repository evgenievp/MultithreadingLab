BlockingQueue – Producer-Consumer Demo

This project demonstrates a basic producer-consumer scenario using Java's BlockingQueue.

The goal is to show how multiple threads can safely exchange data through a shared queue without using explicit synchronization mechanisms such as synchronized, wait, notify, or manual locks.

What it demonstrates

Multiple threads working concurrently
A producer thread adding orders to a shared queue
Multiple consumer threads removing and processing orders
Thread-safe queue operations provided by ArrayBlockingQueue
Basic handling of full and empty queue situations
A simple example of the producer-consumer pattern

How it works

The application uses a StorageClass, which wraps an ArrayBlockingQueue with a fixed capacity of 10 elements.

A producer thread creates Order objects and adds them to the queue.

Several consumer threads try to take orders from the queue and process them. If an order is only partially consumed, the remaining quantity is placed back into the queue as a new order.

Why BlockingQueue is useful

BlockingQueue is designed for concurrent programming. It allows multiple threads to safely add and remove elements from the same queue.

Depending on the method used:

offer() can be used to try adding an element without blocking
poll() can be used to try removing an element without blocking
put() waits if the queue is full
take() waits if the queue is empty

This makes BlockingQueue especially useful for producer-consumer workflows, where producers and consumers work independently but communicate through a shared queue.

Main classes

Order – represents an order with a type and quantity
StorageClass – wraps the BlockingQueue and provides methods for adding and consuming orders
QueueApp – starts the producer and consumer threads

Note

This is a simple demo project created for learning purposes. It focuses on understanding concurrent queue operations and the producer-consumer pattern in Java.
