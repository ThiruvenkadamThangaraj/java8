import java.util.concurrent.CompletableFuture;

// Recursive asynchronous task
public class Threading26_RecursiveTask {
    public static void main(String[] args) {
        System.out.println("Computing fibonacci(10) asynchronously...");
        long start = System.currentTimeMillis();
        
        CompletableFuture<Long> result = fibonacci(10);
        
        System.out.println("Result: " + result.join());
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
    }
    
    static CompletableFuture<Long> fibonacci(int n) {
        if (n <= 1) {
            return CompletableFuture.completedFuture((long) n);
        }
        
        return fibonacci(n - 1)
                .thenCombineAsync(fibonacci(n - 2), Long::sum);
    }
}
