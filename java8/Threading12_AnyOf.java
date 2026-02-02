import java.util.concurrent.CompletableFuture;

// anyOf - Wait for first future to complete
public class Threading12_AnyOf {
    public static void main(String[] args) {
        System.out.println("Starting multiple tasks (anyOf)...");
        
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task 1 started");
                Thread.sleep(3000);
                System.out.println("Task 1 completed");
                return 1;
            } catch (InterruptedException e) { return -1; }
        });
        
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task 2 started");
                Thread.sleep(1000);
                System.out.println("Task 2 completed");
                return 2;
            } catch (InterruptedException e) { return -1; }
        });
        
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task 3 started");
                Thread.sleep(2000);
                System.out.println("Task 3 completed");
                return 3;
            } catch (InterruptedException e) { return -1; }
        });
        
        Object result = CompletableFuture.anyOf(future1, future2, future3).join();
        System.out.println("First completed: " + result);
    }
}
