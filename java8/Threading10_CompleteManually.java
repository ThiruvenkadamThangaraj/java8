import java.util.concurrent.CompletableFuture;

// Complete a future manually
public class Threading10_CompleteManually {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        
        new Thread(() -> {
            try {
                System.out.println("Working on background task...");
                Thread.sleep(2000);
                System.out.println("Task completed!");
                future.complete("Success!");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        }).start();
        
        System.out.println("Waiting for manual completion...");
        String result = future.join();
        System.out.println("Result: " + result);
    }
}
