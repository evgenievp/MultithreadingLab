package com.MathWorkderPool;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class JobStation {
    public static void main(String[] args) {
        AlgebraicWorker algebraicWorker = new AlgebraicWorker();
        GeometricWorker geometricWorker = new GeometricWorker();
        PossibilitiesWorker possibilitiesWorker = new PossibilitiesWorker();
        Random random = new Random();

        Callable<List<Object>> worker1 = () -> {
            List<Object> results = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int choice = random.nextInt(0, 2);
                if (choice == 0) {
                    int checkPrime = random.nextInt(10, 100);
                    results.add(algebraicWorker.factorial(checkPrime));
                } else {
                    int factorialFrom = random.nextInt(4, 15);
                    results.add(algebraicWorker.factorial(factorialFrom));
                }
            }
            return results;
        };
        Callable<List<Object>> worker2 = () -> {
            List<Object> results = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int choice = random.nextInt(0, 2);
                if (choice == 0) {
                    int a = random.nextInt(10, 100);
                    int b = random.nextInt(10, 100);
                    results.add(geometricWorker.rectangleVolume(a, b));
                } else {
                    int n = random.nextInt(4, 15);
                    results.add(geometricWorker.squareVolume(n));
                }
            }
            return results;
        };
        Callable<List<Object>> worker3 = () -> {
            List<Object> results = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                results.add(possibilitiesWorker.calculatePossibility());
            }
            return results;
        };

        var threadExecutor = Executors.newFixedThreadPool(3);

        Future<List<Object>> algebraicResults = threadExecutor.submit(worker1);
        Future<List<Object>> geometricResults = threadExecutor.submit(worker2);
        Future<List<Object>> posibilitiesResults = threadExecutor.submit(worker3);

        try {
            System.out.println("Results from algebraic thread: " + algebraicResults.get(500, TimeUnit.MILLISECONDS));
            System.out.println("Results from geometric thread: " + geometricResults.get(500, TimeUnit.MILLISECONDS));
            System.out.println("Results from possibilities thread: " + posibilitiesResults.get(500, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

        threadExecutor.shutdown();
    }
}
