(In Progress)

Multithreading Java Projects
This repository contains 10 small projects demonstrating different multithreading concepts in Java.

1. Basic Multithreading – Printer Sync
Technologies: Thread, Runnable, synchronized
Project: A classic printer where multiple threads print letters or words sequentially with synchronization.
Goal: Understand synchronized, shared resources, and locking.

2. Banking App – ReentrantLock
Technologies: ReentrantLock, tryLock(), finally
Project: A banking system where users withdraw and deposit money in a shared account.
Goal: Protect shared resources from race conditions.

3. Car Race Simulator – ExecutorService
Technologies: ExecutorService, FixedThreadPool, shutdown()
Project: A car race simulation where each thread represents a car running laps.
Goal: Work with ExecutorService and thread management.

4. Math Worker Pool – Callable & Future
Technologies: Callable, Future, submit(), get()
Project: Workers that calculate factorials, prime numbers, and return results.
Goal: Retrieve results from threads.

5. Task Scheduler – ScheduledExecutorService
Technologies: ScheduledExecutorService, scheduleAtFixedRate
Project: A program simulating an alarm or reminder running periodically.
Goal: Work with delayed and repeated tasks.

6. Producer-Consumer – BlockingQueue
Technologies: BlockingQueue, ArrayBlockingQueue
Project: One producer creates messages, multiple consumers process them.
Goal: Create queues and control access.

7. Parallel Search – WorkStealingPool
Technologies: WorkStealingPool, ForkJoin, RecursiveTask
Project: Parallel search for an element in a large list or set.
Goal: Work with dynamic and optimized threads.

8. File Watcher – WatchService
Technologies: WatchService, Files, Path, ConcurrentLinkedQueue
Project: Monitor a folder for new files and notify on new .txt files.
Goal: React in real time and handle events.

9. Statistics App – Parallel Streams
Technologies: parallelStream, Collectors, Optional
Project: Statistics from a list of numbers – average, median, mode.
Goal: Use functional style with parallel streams.

10. Multithreaded Test System – JUnit + Mockito
Technologies: JUnit, Mockito, assert, Thread.sleep()
Project: Unit tests for the above classes, mocking Logger and DatabaseService.
Goal: Demonstrate best practices and coverage.
