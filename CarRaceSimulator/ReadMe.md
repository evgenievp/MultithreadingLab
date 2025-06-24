Car Race Simulator – Multithreading with ExecutorService
This demo simulates a race between multiple cars, each running on its own thread. Each car progresses through a number of laps, occasionally making pit stops.

What it demonstrates
Use of ExecutorService with a fixed thread pool

Simulating real-time behavior with Thread.sleep()

Isolated state per thread (each car has its own progress and pit stop logic)

How it works
Four race cars (threads) are created and started using a fixed thread pool.

Each car randomly decides when to pit for refueling, tire change, or engine problems.

Cars progress lap by lap until they finish the race.