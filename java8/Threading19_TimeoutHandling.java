import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Timeout handling with orTimeout
public class Threading19_TimeoutHandling {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task started");
                Thread.sleep(5000);
                System.out.println("Task completed");
                return 100;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 0;
            }
        })
        .orTimeout(2, TimeUnit.SECONDS)
        .exceptionally(exception -> {
            if (exception.getCause() instanceof TimeoutException) {
                System.out.println("Task timed out!");
                return -1;
            }
            return 0;
        });
        
        System.out.println("Result: " + future.join());
    }
}
