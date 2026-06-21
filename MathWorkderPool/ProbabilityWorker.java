package com.MathWorkderPool;

import java.util.concurrent.ThreadLocalRandom;

public class ProbabilityWorker {

    public double calculateProbability() {
        int allScenarios = ThreadLocalRandom.current().nextInt(100, 10_000);
        int wantedOutcomes = ThreadLocalRandom.current().nextInt(2, 10);

        double probability = (double) wantedOutcomes / allScenarios;

        System.out.printf(
                "%d wanted outcomes out of %d scenarios. Probability: %.4f%n",
                wantedOutcomes,
                allScenarios,
                probability
        );

        return probability;
    }
}