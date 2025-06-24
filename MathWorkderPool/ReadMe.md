Math Worker Pool – Using Callable and Future
This project simulates a pool of worker threads that perform mathematical tasks concurrently and return results.

What it demonstrates
Use of Callable to return results from tasks

Use of Future to retrieve the results

Managing multiple computational tasks with a fixed thread pool

How it works
Three workers are created:

One for algebraic operations (prime check and factorials)

One for geometric calculations (area of rectangles and squares)

One for probability simulation

Each worker runs in its own thread and returns a list of results

The main thread collects the results using Future.get() with a timeout.
This serves as proof for working purpose.