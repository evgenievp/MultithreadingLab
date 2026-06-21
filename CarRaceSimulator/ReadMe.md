Car Race Simulator – Multithreading with ExecutorService

This project demonstrates a simple race simulation using Java's ExecutorService.

Each race car runs as a separate task inside a fixed thread pool. The cars progress independently through a number of laps and may randomly enter the pit stop for refueling, tire changes, or engine problems.

What it demonstrates

Creating and running concurrent tasks with ExecutorService
Using a fixed thread pool
Running multiple independent simulations in parallel
Simulating delays with Thread.sleep()
Managing isolated state inside each task
Gracefully shutting down an executor

How it works

The application creates several RaceCar objects, each with its own model, speed, lap progress, and pit stop logic.

The Race class starts all cars using a fixed thread pool. Each car runs independently until it completes the required number of laps.

During the race, a car may randomly enter a pit stop. Different pit stop reasons cause different delays:

Refueling 
Tire change
Engine problem

The race ends when all car tasks complete their laps.

Main classes

RaceCar – represents a car participating in the race
Race – creates the cars and runs them using ExecutorService

Note

This demo focuses on running independent tasks concurrently. Since each car has its own internal state, no explicit synchronization is required.
