import java.util.concurrent.CompletableFuture;

// thenAccept - Consume the result without transformation
public class Threading04_ThenAccept {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Computing on: " + Thread.currentThread().getName());
            return 100;
        })
        .thenAccept(result -> {
            System.out.println("Accepted on: " + Thread.currentThread().getName());
            System.out.println("Received value: " + result);
            System.out.println("Processing: " + (result * 2));
        });
        
        future.join();
        System.out.println("Done!");
    }
}
