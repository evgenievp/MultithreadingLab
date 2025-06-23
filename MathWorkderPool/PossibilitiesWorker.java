package com.MathWorkderPool;

import java.util.Random;

public class PossibilitiesWorker {
    private int wantedOutcome;
    private int allScenarios;
    private Random random;
    public PossibilitiesWorker() {
        this.random = new Random();
    }

    public double calculatePossibility() {
        allScenarios = random.nextInt(100, 10_000);
        wantedOutcome = random.nextInt(2, 10);
        double chance = (double) wantedOutcome / allScenarios;
        System.out.printf("Happening of %d outcome of %d possibilities is: %.4f\n", wantedOutcome, allScenarios, chance);
        System.out.printf("Wanted scenario has chance to happen: %.4f \n", chance);
        return chance;
    }


}
