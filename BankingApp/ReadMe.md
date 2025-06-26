Banking App – ReentrantLock Demo
This project simulates a shared bank account accessed by three threads. Each thread performs random deposit and withdrawal operations.

What it demonstrates
Use of ReentrantLock to protect shared resources

Avoiding race conditions

Applying tryLock() with proper lock management using finally

How it works
The SharedBankAccount class maintains the balance and uses a lock.

Each thread tries to acquire the lock to perform an operation.

If successful – the balance is updated. If not – the operation is skipped.

This simulates real-life concurrency in accessing limited resources.

It uses JUnit to test concurrent logic and mocks components using Mockito to isolate logic (e.g., mocking database access or logger services).

Includes:
Thread-safe counter tests
Order service logic with mocked storage
Delayed task execution verification

Technologies:
JUnit 5
Mockito
assertAll, assertEquals, verify()