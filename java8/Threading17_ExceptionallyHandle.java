import java.util.concurrent.CompletableFuture;

// exceptionally - Handle only exceptions
public class Threading17_ExceptionallyHandle {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Processing on: " + Thread.currentThread().getName());
            System.out.println("Something went wrong!");
            return 42;
        })
        .exceptionally(exception -> {
            System.out.println("Caught exception: " + exception.getClass().getSimpleName());
            System.out.println("Message: " + exception.getMessage());
            return -1;
        })
        .thenApply(result -> {
            System.out.println("Got result: " + result);
            return result * 2;
        });
        
        System.out.println("Final: " + future.join());
    }
}
