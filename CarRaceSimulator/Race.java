package com.CarRaceSimulator;

import java.util.List;
import java.util.concurrent.Executors;

public class Race {
    public static void main(String[] args) {
        final int laps = 10;
        RaceCar mercedes = new RaceCar("Mercedes", 310, laps);
        RaceCar ferrari = new RaceCar("Ferrari", 330, laps);
        RaceCar renault = new RaceCar("Renault", 300, laps);
        RaceCar bmw = new RaceCar("BMW", 290, laps);

        Runnable mercedesCar = new Runnable() {
            @Override
            public void run() {
                mercedes.start();
            }
        };

        Runnable bmwCar = new Runnable() {
            @Override
            public void run() {
                bmw.start();
            }
        };

        Runnable ferrariCar = new Runnable() {
            @Override
            public void run() {
                ferrari.start();
            }
        };
        Runnable renaultCar = new Runnable() {
            @Override
            public void run() {
                renault.start();
            }
        };


        var raceStarter = Executors.newFixedThreadPool(4);
        raceStarter.execute(mercedesCar);
        raceStarter.execute(bmwCar);
        raceStarter.execute(renaultCar);
        raceStarter.execute(ferrariCar);

        raceStarter.shutdown();

    }
}
