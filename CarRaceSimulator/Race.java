package com.CarRaceSimulator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;


public class Race {
    public static void main(String[] args) {
        final int laps = 10;

        List<RaceCar> cars = List.of(
                new RaceCar("Mercedes", 310, laps),
                new RaceCar("Ferrari", 330, laps),
                new RaceCar("Renault", 300, laps),
                new RaceCar("BMW", 290, laps)
        );

        ExecutorService executor = Executors.newFixedThreadPool(cars.size());

        List<Future<RaceResult>> futures = new ArrayList<>();

        for (RaceCar car : cars) {
            futures.add(executor.submit(car));
        }

        List<RaceResult> results = new ArrayList<>();

        for (Future<RaceResult> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executor.shutdown();

        results.sort(Comparator.comparingLong(RaceResult::timeMillis));

        System.out.println();
        System.out.println("=== FINAL RANKING ===");

        for (int i = 0; i < results.size(); i++) {
            RaceResult result = results.get(i);

            System.out.printf(
                    "%d. %s - %d ms%n",
                    i + 1,
                    result.model(),
                    result.timeMillis()
            );
        }
    }
}