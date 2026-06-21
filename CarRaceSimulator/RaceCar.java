package com.CarRaceSimulator;

import com.CarRaceSimulator.RaceResult;
import java.util.Random;
import java.util.concurrent.Callable;

public class RaceCar implements Callable<RaceResult> {
    private final int speed;
    private final int lapLength = 2300;
    private final int laps;
    private final String model;
    private final Random random = new Random();

    private int distanceInCurrentLap;
    private int lapsPassed;

    public RaceCar(String model, int speed, int laps) {
        this.model = model;
        this.speed = speed;
        this.laps = laps;
    }

    @Override
    public RaceResult call() {
        long startTime = System.currentTimeMillis();

        while (lapsPassed < laps) {
            int pitChance = random.nextInt(0, laps);

            if (pitChance == 1) {
                String reason = pitStop();
                System.out.println(model + " entered the pit stop for " + reason);
            } else {
                progress();
            }
        }

        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;

        System.out.println(model + " finished the race");

        return new RaceResult(model, totalTime);
    }

    private void progress() {
        distanceInCurrentLap += speed;

        if (distanceInCurrentLap >= lapLength) {
            distanceInCurrentLap -= lapLength;
            lapsPassed++;
            System.out.println(model + " passed lap " + lapsPassed);
        }
    }

    private String pitStop() {
        int pitStopReason = random.nextInt(0, 3);

        try {
            return switch (pitStopReason) {
                case 0 -> {
                    Thread.sleep(100);
                    yield "refueling";
                }
                case 1 -> {
                    Thread.sleep(20);
                    yield "new tires";
                }
                default -> {
                    Thread.sleep(400);
                    yield "engine problem";
                }
            };
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Pit stop interrupted", e);
        }
    }
}