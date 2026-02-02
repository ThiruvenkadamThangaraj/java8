import java.util.concurrent.CompletableFuture;

// runAsync - Fire and forget (no return value)
public class Threading02_RunAsync {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());
        
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running on: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("Task completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        future.join();
        System.out.println("Main completed");
    }
}
