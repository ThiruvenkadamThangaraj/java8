import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// CompletableFuture basics
public class Program50_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Simple async computation
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        
        System.out.println("Waiting for result...");
        System.out.println("Result: " + future.get());
        
        // Chain operations
        CompletableFuture<String> chainedFuture = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenApply(String::toUpperCase);
        
        System.out.println("Chained result: " + chainedFuture.get());
        
        // Combine futures
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);
        
        CompletableFuture<Integer> combined = future1.thenCombine(future2, Integer::sum);
        System.out.println("Combined: " + combined.get());
    }
}
