Task Scheduler – Using ScheduledExecutorService
This project simulates a recurring alarm using scheduled tasks in Java.

What it demonstrates
Usage of ScheduledExecutorService

Periodic task execution with fixed delay

Graceful shutdown of executor after a certain duration

How it works
A simple Alarm class prints the current time when triggered

The task is scheduled to run every 10 seconds after an initial delay

The application stops execution after a predefined sleep time and it must be like this, 
since executor.shutdown() would close immediately after start without let threads to finish.