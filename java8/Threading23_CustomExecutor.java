import java.util.concurrent.*;

// Using custom ExecutorService with CompletableFuture
public class Threading23_CustomExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        System.out.println("Starting with custom executor (3 threads)...");
        
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 on " + Thread.currentThread().getName());
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            return 10;
        }, executor);
        
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 on " + Thread.currentThread().getName());
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            return 20;
        }, executor);
        
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 3 on " + Thread.currentThread().getName());
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            return 30;
        }, executor);
        
        CompletableFuture.allOf(future1, future2, future3).join();
        
        System.out.println("Sum: " + (future1.join() + future2.join() + future3.join()));
        
        executor.shutdown();
    }
}
