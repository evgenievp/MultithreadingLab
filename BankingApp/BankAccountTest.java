
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testConcurrentDeposits() throws InterruptedException {
        SharedBankAccount account = new SharedBankAccount(1000);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable depositTask = () -> {
            for (int i = 0; i < 10; i++) {
                account.deposit(10);
            }
        };

        executor.submit(depositTask);
        executor.submit(depositTask);

        executor.shutdown();
        boolean finished = executor.awaitTermination(2, TimeUnit.SECONDS);

        assertTrue(finished);
        assertEquals(1200, account.getBalance(), 0.001);
    }

}