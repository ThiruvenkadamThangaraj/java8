import java.util.concurrent.CompletableFuture;

// Handling cancellation in CompletableFuture
public class Threading31_CancellationHandling {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        
        Thread taskThread = new Thread(() -> {
            try {
                System.out.println("Task started on " + Thread.currentThread().getName());
                Thread.sleep(5000);
                System.out.println("Task completed");
                future.complete(100);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
                future.completeExceptionally(e);
            }
        });
        
        taskThread.start();
        
        Thread.sleep(1000);
        System.out.println("Cancelling task...");
        boolean cancelled = future.cancel(true);
        System.out.println("Cancelled: " + cancelled);
        System.out.println("Is cancelled: " + future.isCancelled());
        
        taskThread.join();
    }
}
