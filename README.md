# Java Concurrency Lab
This repository has the goal to be a set of 10 small and focused Java projects that explore key concepts in multithreaded and concurrent programming. Each project demonstrates a specific technology or approach using a practical, self-contained example.

## Projects Overview

1. Basic Multithreading – Printer Sync
* **Technologies**: `Thread`, `Runnable`, `synchronized`
* **Description**: Multiple threads print characters or words in a synchronized sequence.
* **Goal**: Understand thread creation, synchronization, and access to shared resources.
---
2. Banking App – ReentrantLock
* **Technologies**: `ReentrantLock`, `tryLock()`, `finally`
* **Description**: Simulates a bank system where users deposit and withdraw from a shared account.
* **Goal**: Prevent race conditions and safely manage concurrent access to critical sections.
---
3. Car Race Simulator – ExecutorService
* **Technologies**: `ExecutorService`, `FixedThreadPool`, `shutdown()`
* **Description**: Each thread represents a car in a race completing multiple laps.
* **Goal**: Use thread pools for task execution and manage their lifecycle.
---
4. Math Worker Pool – Callable & Future
* **Technologies**: `Callable`, `Future`, `submit()`, `get()`
* **Description**: A pool of workers performs mathematical calculations and returns results.
* **Goal**: Execute tasks asynchronously and retrieve computed values.
---
5. Task Scheduler – ScheduledExecutorService
* **Technologies**: `ScheduledExecutorService`, `scheduleAtFixedRate()`
* **Description**: Simulates a scheduler that triggers periodic alarms or reminders.
* **Goal**: Handle delayed and recurring tasks.
---
6. Producer-Consumer – BlockingQueue
* **Technologies**: `BlockingQueue`, `ArrayBlockingQueue`
* **Description**: A producer generates messages while multiple consumers process them.
* **Goal**: Coordinate producers and consumers using a thread-safe queue.
---
7. Parallel Search – ForkJoinPool
* **Technologies**: `ForkJoinPool`, `RecursiveTask`
* **Description**: Parallel search for a target value within a large list or array.
* **Goal**: Apply divide-and-conquer with work stealing for efficient parallelism.
---
8. File Watcher – WatchService
* **Technologies**: `WatchService`, `Path`, `ConcurrentLinkedQueue`
* **Description**: Monitors a directory and notifies when new `.txt` files are added.
* **Goal**: React to file system events in real time.
---
9. Statistics App – Parallel Streams
* **Technologies**: `parallelStream()`, `Collectors`, `Optional`
* **Description**: Computes mean, median, and mode from a list of numbers.
* **Goal**: Use parallel streams and functional style to process collections.
---
10. Multithreaded Test System – JUnit & Mockito
* **Technologies**: `JUnit`, `Mockito`, `Thread.sleep()`
* **Description**: Unit tests for the projects above, with mocked components like loggers and services.
* **Goal**: Demonstrate good testing practices for multithreaded code.

Purpose
This is a hands-on lab designed to solidify understanding of Java concurrency through real-world inspired examples. Each project is standalone and highlights a different concurrency mechanism or pattern.
