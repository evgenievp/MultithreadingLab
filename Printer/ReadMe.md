Printer Sync – Basic Multithreading with synchronized.
This project simulates multiple threads printing lines from a shared text resource (a poem file). Each line is printed exactly once.

What it demonstrates
Basic use of Java threads (Thread, Runnable)

Thread safety with synchronized blocks

Shared state management using a counter

How it works
Five threads are started, all sharing a Printer instance.

The Printer class reads lines from a file and uses synchronized to ensure only one thread prints at a time.

The output shows that threads cooperate to print without overlapping or skipping lines.