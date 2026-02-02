import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

// Timeout with fallback strategy
public class Threading46_TimeoutWithFallback {
    public static void main(String[] args) {
        CompletableFuture<String> primarySource = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Fetching from primary source...");
                Thread.sleep(5000);
                return "Data from primary";
            } catch (InterruptedException e) {
                return null;
            }
        });
        
        CompletableFuture<String> fallback = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Fallback ready");
                Thread.sleep(500);
                return "Data from fallback";
            } catch (InterruptedException e) {
                return null;
            }
        });
        
        CompletableFuture<String> result = primarySource
                .orTimeout(2, TimeUnit.SECONDS)
                .exceptionally(ex -> fallback.join());
        
        System.out.println("Result: " + result.join());
    }
}
