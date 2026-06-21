 Java Multithreading Practice Projects

This repository contains 10 small Java demo projects focused on core multithreading and concurrency concepts.

The goal of these projects is not to build production-ready applications, but to demonstrate how different Java concurrency tools work in simple, isolated examples.

Each project focuses on a specific topic such as thread synchronization, shared resources, locks, thread pools, blocking queues, scheduled tasks, futures, parallel processing, and testing concurrent code.

 Projects

 1. Synchronized Printer – Shared Resource Demo

Technologies: Thread, Runnable, synchronized

A simple printer simulation where multiple threads share the same printer object and print lines from a text file.

The shared line counter is protected with a synchronized method, preventing duplicated or skipped lines.

Goal: Understand shared mutable state, synchronization, and basic thread coordination.

---

 2. Banking App – ReentrantLock Demo

Technologies: ReentrantLock, tryLock(), finally

A banking simulation where multiple threads deposit and withdraw money from the same shared bank account.

Access to the account balance is protected with a ReentrantLock.

Goal: Understand explicit locking, race conditions, and safe access to shared resources.

---

 3. Car Race Simulator – ExecutorService Demo

Technologies: ExecutorService, FixedThreadPool, Callable, Future, shutdown()

A race simulation where each car runs as a separate task in a fixed thread pool.

Each car has its own progress, speed, lap count, and pit stop logic. At the end, results can be collected and sorted into a final ranking.

Goal: Understand task execution, thread pools, result collection, and executor shutdown.

---

 4. Math Worker Pool – Callable and Future Demo

Technologies: Callable, Future, submit(), get(), TimeoutException

Several worker tasks perform simple mathematical operations such as factorial calculation, prime number checks, geometry calculations, and probability calculations.

Each worker returns results through a Future.

Goal: Understand how to submit tasks that return values and how to retrieve asynchronous results.

---

 5. Task Scheduler – ScheduledExecutorService Demo

Technologies: ScheduledExecutorService, schedule(), scheduleAtFixedRate()

A small scheduler simulation that runs tasks after a delay or repeatedly at fixed intervals.

Example use cases include reminders, alarms, or periodic status messages.

Goal: Understand delayed and repeated task execution.

---

 6. Producer-Consumer – BlockingQueue Demo

Technologies: BlockingQueue, ArrayBlockingQueue, put(), take(), offer(), poll()

A producer-consumer simulation where one or more producers create orders and multiple consumers process them.

The queue handles thread-safe communication between producers and consumers without manual locking.

Goal: Understand producer-consumer workflows and blocking queue behavior.

---

 7. Parallel Search – ForkJoin / WorkStealingPool Demo

Technologies: ForkJoinPool, RecursiveTask, WorkStealingPool

A parallel search demo that splits a large collection into smaller tasks and searches for a target value concurrently.

Goal: Understand task splitting, recursive parallelism, and work-stealing execution.

---

 8. File Watcher – WatchService Demo

Technologies: WatchService, Files, Path, ConcurrentLinkedQueue

A file monitoring demo that watches a folder and reacts when new files are created.

Detected file events can be stored in a concurrent queue for further processing.

Goal: Understand file system events and thread-safe event handling.

---

 9. Statistics App – Parallel Streams Demo

Technologies: parallelStream(), Collectors, Optional

A statistics demo that processes a list of numbers using Java streams and parallel streams.

It calculates values such as average, minimum, maximum, median, or mode.

Goal: Understand functional-style data processing and the difference between sequential and parallel stream execution.

---

 10. Multithreaded Tests – JUnit and Mockito

Technologies: JUnit, Mockito, assertions, concurrent execution tests

Unit tests for selected demo classes, focusing on correctness, expected results, and basic concurrent behavior.

Some tests may use mocked dependencies such as a logger or external service.

Goal: Practice testing concurrent code and validating thread-safe behavior.

 Main Concepts Covered

 Creating and starting threads
 Implementing Runnable and Callable
 Synchronizing access to shared resources
 Using explicit locks with ReentrantLock
 Using thread pools with ExecutorService
 Returning results with Future
 Scheduling repeated tasks
 Using blocking queues for producer-consumer workflows
 Splitting work with ForkJoinPool
 Processing data with parallel streams
 Writing basic tests for concurrent code

 Note

These projects are educational demos. Each project is intentionally small and focused on one main concurrency concept.
