import java.util.concurrent.CompletableFuture;

// allOf - Wait for all futures to complete
public class Threading11_AllOf {
    public static void main(String[] args) {
        System.out.println("Starting parallel tasks...");
        
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Task 1 started");
                Thread.sleep(2000);
                System.out.println("Task 1 completed");
            } catch (InterruptedException e) { e.printStackTrace(); }
        });
        
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Task 2 started");
                Thread.sleep(1500);
                System.out.println("Task 2 completed");
            } catch (InterruptedException e) { e.printStackTrace(); }
        });
        
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Task 3 started");
                Thread.sleep(1000);
                System.out.println("Task 3 completed");
            } catch (InterruptedException e) { e.printStackTrace(); }
        });
        
        CompletableFuture.allOf(future1, future2, future3).join();
        System.out.println("All tasks completed!");
    }
}
