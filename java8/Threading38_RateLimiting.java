import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

// Rate limiting with CompletableFuture
public class Threading38_RateLimiting {
    static class RateLimiter {
        private Semaphore semaphore;
        
        RateLimiter(int maxConcurrent) {
            this.semaphore = new Semaphore(maxConcurrent);
        }
        
        CompletableFuture<String> execute(String taskName) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Executing " + taskName);
                    Thread.sleep(1000);
                    return "Completed " + taskName;
                } catch (InterruptedException e) {
                    return "Interrupted";
                } finally {
                    semaphore.release();
                }
            });
        }
    }
    
    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter(2);
        
        System.out.println("Starting rate-limited tasks (max 2 concurrent)...");
        
        for (int i = 1; i <= 5; i++) {
            final int taskNum = i;
            limiter.execute("Task-" + i)
                    .thenAccept(System.out::println);
        }
        
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
