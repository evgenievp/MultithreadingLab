Math Worker Pool – Callable and Future Demo

This project demonstrates how to execute independent computational tasks concurrently using Java's ExecutorService, Callable, and Future.

The application creates several worker tasks:

- AlgebraicWorker – calculates factorials and checks prime numbers
- GeometricWorker – calculates simple geometric areas
- ProbabilityWorker – calculates random probability scenarios

Each worker task runs in a fixed thread pool and returns a list of results. The main thread retrieves the results through Future.get() with a timeout.

What it demonstrates

- Using ExecutorService with a fixed thread pool
- Submitting Callable tasks that return results
- Retrieving asynchronous results with Future
- Handling TimeoutException, ExecutionException, and InterruptedException
- Running independent computational tasks concurrently

Note

This is a learning demo focused on task execution and result collection, not on complex mathematical algorithms.