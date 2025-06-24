Parallel Search – WorkStealingPool Demo
This demo showcases parallel search using Java's WorkStealingPool.

What it demonstrates
Splitting a large array into segments

Executing search tasks in parallel using ExecutorService.newWorkStealingPool()

Efficient use of available CPU cores through work-stealing threads

How it works
A large array is filled with random numbers

One element is set to a known target value (-1)

The array is divided into chunks, and each chunk is searched in parallel

The task that finds the element prints its index and terminates

This project demonstrates how parallelism improves performance when searching large datasets.