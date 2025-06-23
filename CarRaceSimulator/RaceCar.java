package com.CarRaceSimulator;

import java.util.Random;

public class RaceCar {
    private int speed;
    private final int lapLength = 2300;
    private int currentLap;
    private int lapsPassed = 0;
    private int laps;
    private String model;
    private Random random;

    public RaceCar(String model, int speed, int laps) {
        this.model = model;
        this.random = new Random();
        this.speed = speed;
        this.laps = laps;
        this.currentLap = 0;
    }

    private String box() {
        int boxNeed = random.nextInt(0, 2);
        String word;
        switch (boxNeed) {
            case 0 -> {
                word="refuel";
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            case 1 -> {
                word="new tires";
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                word="engine problem";
            }
        }
        return word;
    }
    private void progress() {
        currentLap += speed;
        if (currentLap >= lapLength) {
            currentLap -= lapLength;
            lapsPassed ++;
            System.out.println(this.model + " pass a lap");
        }
        if (currentLap == laps) {
            System.out.println(this.model + " finished race");
        }
        else {
            currentLap += lapLength;
        }
    }

    public void start(){
        String word;
        while (lapsPassed < laps) {
            int boxChance = random.nextInt(0, laps);
            if (boxChance == 1) {
                word = box();
                System.out.println(this.model + " has to visit the box and " + word);
            }
            else {
                progress();
            }
        }
        System.out.println(model + " Finished");
    }
    public String toString() {
        return this.model;
    }
}
