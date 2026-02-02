import java.util.concurrent.CompletableFuture;

// Chain of dependent async tasks
public class Threading28_DependentTasks {
    public static void main(String[] args) {
        System.out.println("Starting dependent task chain...");
        
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1: Fetch user ID");
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            return 123;
        });
        
        CompletableFuture<String> task2 = task1.thenApplyAsync(userId -> {
            System.out.println("Task 2: Fetch user name for ID " + userId);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return "Alice";
        });
        
        CompletableFuture<String> task3 = task2.thenApplyAsync(name -> {
            System.out.println("Task 3: Fetch email for " + name);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return name + "@example.com";
        });
        
        System.out.println("Email: " + task3.join());
    }
}
