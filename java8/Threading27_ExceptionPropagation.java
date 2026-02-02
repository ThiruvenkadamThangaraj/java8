import java.util.concurrent.CompletableFuture;

// Exception propagation in pipeline
public class Threading27_ExceptionPropagation {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: Computing");
            return 10;
        })
        .thenApply(n -> {
            System.out.println("Step 2: Processing " + n);
            throw new RuntimeException("Error in step 2!");
        })
        .thenApply(n -> {
            System.out.println("Step 3: This won't execute");
            return n * 2;
        })
        .exceptionally(ex -> {
            System.out.println("Caught exception: " + ex.getMessage());
            System.out.println("Returning default value");
            return -1;
        });
        
        System.out.println("Final result: " + future.join());
    }
}
