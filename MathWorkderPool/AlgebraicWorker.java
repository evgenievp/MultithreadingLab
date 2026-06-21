package com.MathWorkderPool;

import java.math.BigInteger;

public class AlgebraicWorker {

    public BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }

        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}