import java.util.concurrent.CompletableFuture;

// thenApply - Transform the result
public class Threading03_ThenApply {
    public static void main(String[] args) {
        System.out.println("Starting...");
        
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1 on: " + Thread.currentThread().getName());
            return 10;
        })
        .thenApply(num -> {
            System.out.println("Step 2 on: " + Thread.currentThread().getName());
            return num * 2;
        })
        .thenApply(num -> {
            System.out.println("Step 3 on: " + Thread.currentThread().getName());
            return num + 5;
        });
        
        System.out.println("Result: " + future.join());
    }
}
