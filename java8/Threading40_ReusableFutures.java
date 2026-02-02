import java.util.concurrent.CompletableFuture;

// Creating reusable async patterns
public class Threading40_ReusableFutures {
    static <T> CompletableFuture<T> delay(T value, long milliseconds) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(milliseconds);
                return value;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    static <T> CompletableFuture<T> retry(CompletableFuture<T> future, int maxRetries) {
        return future.exceptionally(ex -> {
            if (maxRetries > 0) {
                System.out.println("Retrying... (" + maxRetries + " attempts left)");
                return retry(new CompletableFuture<>(), maxRetries - 1).join();
            }
            throw new RuntimeException(ex);
        });
    }
    
    public static void main(String[] args) {
        System.out.println("Using reusable patterns...");
        
        CompletableFuture<String> result = delay("Hello", 1000)
                .thenCompose(value -> delay(value + " World", 500));
        
        System.out.println(result.join());
    }
}
