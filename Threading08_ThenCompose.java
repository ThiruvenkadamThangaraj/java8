import java.util.concurrent.CompletableFuture;

// thenCompose - Flatten nested CompletableFuture
public class Threading08_ThenCompose {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1 on: " + Thread.currentThread().getName());
            return 10;
        })
        .thenCompose(num -> {
            System.out.println("Step 2 on: " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> {
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                return "Number was: " + num;
            });
        });
        
        System.out.println("Result: " + future.join());
    }
}
