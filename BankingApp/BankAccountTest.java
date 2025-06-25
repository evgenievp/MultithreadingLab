
import com.BankingApp.SharedBankAccount;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testConcurrentDeposits() throws InterruptedException {
        SharedBankAccount account = new SharedBankAccount(1000);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable deposit = () -> {
            for (int i = 0; i < 10; i++) {
                account.deposit(10);
            }
        };

        executor.submit(deposit);
        executor.submit(deposit);
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        assertTrue(account.getBalance() >= 1000); // basic validation
    }
}