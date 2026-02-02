import java.util.concurrent.CompletableFuture;

// thenApplyAsync - Each step on different thread
public class Threading07_ThenApplyAsync {
    public static void main(String[] args) {
        System.out.println("Main on: " + Thread.currentThread().getName());
        
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1 on: " + Thread.currentThread().getName());
            return 5;
        })
        .thenApplyAsync(num -> {
            System.out.println("Step 2 on: " + Thread.currentThread().getName());
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return num * 2;
        })
        .thenApplyAsync(num -> {
            System.out.println("Step 3 on: " + Thread.currentThread().getName());
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return num + 10;
        });
        
        System.out.println("Result: " + future.join());
    }
}
