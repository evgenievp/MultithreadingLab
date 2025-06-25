import java.util.*;

public class StatsApp {
    public static void main(String[] args) {
        List<Integer> data = new Random().ints(1_000_000, 1, 100).boxed().toList();

        double average = data.parallelStream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        int max = data.parallelStream().mapToInt(Integer::intValue).max().orElse(0);
        int min = data.parallelStream().mapToInt(Integer::intValue).min().orElse(0);

        System.out.printf("Average: %.2f, Max: %d, Min: %d%n", average, max, min);
    }
}
