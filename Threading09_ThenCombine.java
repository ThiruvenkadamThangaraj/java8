import java.util.concurrent.CompletableFuture;

// thenCombine - Combine results of two futures
public class Threading09_ThenCombine {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 1 on: " + Thread.currentThread().getName());
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            return 20;
        });
        
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 2 on: " + Thread.currentThread().getName());
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return 30;
        });
        
        CompletableFuture<Integer> combined = future1.thenCombine(future2, (a, b) -> {
            System.out.println("Combining on: " + Thread.currentThread().getName());
            System.out.println("Future1: " + a + ", Future2: " + b);
            return a + b;
        });
        
        System.out.println("Combined result: " + combined.join());
    }
}
