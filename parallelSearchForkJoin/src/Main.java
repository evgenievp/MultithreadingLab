import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int numbersCount = 100_000;
        Random random = new Random();
        long[] arrayOfNumbers = random.longs(numbersCount,
        10, 100_000_000).toArray();
        var executor = Executors.newWorkStealingPool(3);

        int n = random.nextInt(1, 100_000);
        arrayOfNumbers[n] = -1;

        int searchInAmount = 100_000 / 10;
        for (int i = 0; i < 10; i++) {
            int startIdxSearch = i * searchInAmount;
            int endIdxSearch = startIdxSearch + 10000;
            Runnable currentThread = new Runnable() {
                @Override
                public void run() {
                    for (int j = startIdxSearch; j < endIdxSearch; j++) {
                        if (arrayOfNumbers[j] == -1) {
                            System.out.println("Found it on idx " + j);
                            return;
                        }
                    }
                }

            };
            executor.execute(currentThread);
        }

        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}